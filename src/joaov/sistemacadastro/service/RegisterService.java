package joaov.sistemacadastro.service;

import joaov.sistemacadastro.exceptions.EmailException;
import joaov.sistemacadastro.exceptions.LessThanEighteenException;
import joaov.sistemacadastro.exceptions.ShortNameException;
import joaov.sistemacadastro.model.User;
import joaov.sistemacadastro.util.FileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterService {
    private final Scanner scanner = new Scanner(System.in);
    private List<String> questions = FileHandler.formsReader(FileHandler.getFORMS_FILE());
    private List<String> answers;
    private List<User> users;

    public RegisterService() {
        this.answers = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void doQuestions() {
        for (String question : questions) {
            System.out.println(question);
            answers.add(scanner.nextLine());

            exceptionsHandler(answers);
        }

        createUser();
        FileHandler.usersWriter(users);
        System.out.println();
    }

    private void createUser() {
        User user = new User(answers.get(0), answers.get(1), Byte.parseByte(answers.get(2)), Double.parseDouble(answers.get(3).replace(",", ".")));
        if (answers.size() > 4) {
            for (int i = 4; i < answers.size(); i++) {
                user.getNewAnswers().add(answers.get(i));
            }
        }

        users.add(user);
        answers.clear();
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public List<User> getUsers() {
        return users;
    }

    private boolean checkRepeatedEmails(String email) {
        for (User u: users) {
            if (u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private void exceptionsHandler(List<String> answers) {
        if (answers.getFirst().length() < 10) {
            throw new ShortNameException();
        }

        if (answers.size() > 1) {
            if (!answers.get(1).contains("@")) {
                throw new EmailException();
            }

            if (checkRepeatedEmails(answers.get(1))) {
                throw new EmailException("Email ja cadastrado no sistema");
            }
        }

        if (answers.size() > 2) {
            if (Byte.parseByte(answers.get(2)) < 18) {
                throw new LessThanEighteenException();
            }
        }

        if (answers.size() > 3) {
            if (answers.get(3).contains(".")) {
                throw new IllegalArgumentException("Altura inválida: Altura deve ser preenchida com ','");
            }
        }
    }
}
