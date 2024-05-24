import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonRegistration {
    private static final String FORMS_FILE = "formulario.txt";

    private Scanner sc = new Scanner(System.in);
    private FileWriter fileWriter;
    private String userQuestion;

    public void addPersonToTxt(int i, Person person) {
        try {
            fileWriter = new FileWriter(i + " - " + person.getName().toUpperCase().replace(" ", "") + ".txt");
            fileWriter.write(person.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void questionsReader(List<String> questions) {
        try {
            FileReader file = new FileReader(FORMS_FILE);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                questions.add(line);
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addedPersonList(List<Person> personList) {
        for (int i = 0; i < personList.size(); i++) {
            System.out.println((i+1) + " - " + personList.get(i).getName());
        }
    }

    public void register(List<Person> personList, List<String> questions) {
        Person person = new Person();
        List<String> userAnswer = new ArrayList<>();
        List<String> newUserAnswer = new ArrayList<>();

        for (int i = 0; i < questions.size(); i++) {
            System.out.println(questions.get(i));
            String answer = sc.nextLine();
            userAnswer.add(answer);
        }

        String name = userAnswer.get(0);
        String email = userAnswer.get(1);
        int age = Integer.parseInt(userAnswer.get(2));
        double height = Double.parseDouble(userAnswer.get(3));

        if (questions.size() > 4) {
            for (int i = 4; i < questions.size(); i++) {
                newUserAnswer.add(userAnswer.get(i));
            }
            person = new Person(name, email, age, height, newUserAnswer);
        } else {
            person = new Person(name, email, age, height);
        }

        System.out.println();
        System.out.println(person);
        personList.add(person);
        addPersonToTxt(personList.size(), person);
        userAnswer.clear();
    }

    public void addNewQuestion(List<String> questions) {
        System.out.print("Digite a pergunta a ser adicionada ao formulario: ");
        this.userQuestion = sc.nextLine();
        questions.add((questions.size() + 1) + " - " + this.userQuestion + "?");

        try {
            fileWriter = new FileWriter(FORMS_FILE, true);
            fileWriter.write("\n" + questions.getLast());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeNewQuestions(List<String> questions) {
        System.out.println();
        questions.forEach(System.out::println);
        System.out.println();
        System.out.print("Digite o numero da pergunta a ser removida do formulario: ");
        int questionIndex = sc.nextInt() - 1;
        sc.nextLine();

        if (questionIndex != 0 && questionIndex != 1 && questionIndex != 2 && questionIndex != 3) {
            if (questions.get(questionIndex).equals(questions.getLast())) {
                questions.remove(questionIndex);
            }
            else {
                questions.remove(questionIndex);
                if (questions.size() > 4) {
                    questions.set(questionIndex, (questions.size()) + " - " + this.userQuestion + "?");
                }
            }

            System.out.println("Pergunta " + (questionIndex + 1) + " removida.");
            try {
                fileWriter = new FileWriter(FORMS_FILE);
                for (String question : questions) {
                    if (question.equals(questions.getLast())) {
                        fileWriter.write(question);
                    } else {
                        fileWriter.write(question + "\n");
                    }
                }
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("As perguntas 1, 2, 3 e 4 nao podem ser removidas");
        }
    }

    public void userSearch(List<Person> personList) {
        List<String> filteredNames = new ArrayList<>();
        System.out.println();
        System.out.print("Digite o nome, idade ou email para buscar pessoas cadastradas: ");
        String search = sc.nextLine();
        System.out.print("Cadastrados: ");
        personList.stream().filter(p -> p.getName().contains(search) || p.getEmail().contains(search) || String.valueOf(p.getAge()).contains(search))
                .forEach(p -> filteredNames.add(p.getName()));
        filteredNames.forEach(p -> System.out.print((p.equals(filteredNames.getLast())) ? p : p + ", "));
        System.out.println();
    }
}
