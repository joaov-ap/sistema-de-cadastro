package joaov.sistemacadastro.util;

import joaov.sistemacadastro.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final File FORMS_FILE = new File("/home/joao/Documents/sistema-de-cadastro/src/joaov/sistemacadastro/files/formulario.txt");
    private static final File TEMP_FILE = new File("/home/joao/Documents/sistema-de-cadastro/src/joaov/sistemacadastro/files/tempQuestions.txt");

    public static List<String> formsReader(File file) {
        String line;
        List<String> questions = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((line = bufferedReader.readLine()) != null) {
                questions.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return questions;
    }

    public static void formsWriter(List<String> questions, File file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < questions.size(); i++) {
                if (i + 1 == questions.size()) {
                    bufferedWriter.write(questions.get(i));
                } else {
                    bufferedWriter.write(questions.get(i) + "\n");
                }
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void usersWriter(List<User> users) {
        String user = users.size() + "-" + users.getLast().getName().replace(" ", "").toUpperCase() + ".txt";
        File file = new File("/home/joao/Documents/sistema-de-cadastro/src/joaov/sistemacadastro/files/users/" + user);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(users.getLast().toString());
            for (String i : users.getLast().getNewAnswers()) {
                bufferedWriter.write("\n" + i);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static File getFORMS_FILE() {
        return FORMS_FILE;
    }

    public static File getTEMP_FILE() {
        return TEMP_FILE;
    }
}
