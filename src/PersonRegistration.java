import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonRegistration {
    private static final String FORMS_FILE = "formulario.txt";
    private List<String> userAnswer = new ArrayList<>();
    private FileWriter fileWriter;
    private Scanner sc = new Scanner(System.in);
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
        for (String question : questions) {
            System.out.println(question);
            String answer = sc.nextLine();
            userAnswer.add(answer);
        }

        String name = userAnswer.get(0);
        String email = userAnswer.get(1);
        int age = Integer.parseInt(userAnswer.get(2));
        double height = Double.parseDouble(userAnswer.get(3));

        Person person = new Person(name, email, age, height);
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
            fileWriter.write("\n" + questions.get(questions.size() - 1));
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

        if (questionIndex != 0 && questionIndex != 1 && questionIndex != 2 && questionIndex != 3) {
            System.out.print("Voce realmente deseja excluir a pergunta: ");
            System.out.println('"' + questions.get(questionIndex) + '"');
            System.out.println("1 - Sim\n2 - Não");
            int confirm = sc.nextInt();

            switch (confirm) {
                case 1:
                    questions.remove(questionIndex);
                    System.out.println("Pergunta " + (questionIndex + 1) + " removida.");
                    try {
                        fileWriter = new FileWriter(FORMS_FILE);
                        if (questions.size() > 4) {
                            questions.set(questionIndex, (questions.size()) + " - " + this.userQuestion + "?");
                        }
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
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Escolha entre 1 e 2!");
                    break;
            }
        } else {
            System.out.println("As perguntas 1, 2, 3 e 4 nao podem ser removidas");
        }
    }
}
