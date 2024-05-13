import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonRegistration {
    private final String FORMS = "formulario.txt";

    private List<String> questions = new ArrayList<>();
    private List<String> userAnswer = new ArrayList<>();

    public void addPersonToTxt(int i, Person person) {
        try {
            FileWriter fileWriter = new FileWriter(i + " - " + person.getName().toUpperCase().replace(" ", "") + ".txt");
            fileWriter.write(person.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getQuestionsSize() {
        int i = 0;
        try {
            FileReader file = new FileReader(FORMS);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                i++;
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    public void questionsReader() {
        try {
            FileReader file = new FileReader(FORMS);
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

    public void register(List<Person> personList) {
        Scanner sc = new Scanner(System.in);
        questionsReader();

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

    public void addNewQuestion() {
        questionsReader();
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a pergunta para ser adicionada ao formulario: ");
        String userQuestion = sc.nextLine();
        questions.add((getQuestionsSize() + 1) + " - " + userQuestion + "?");

        try {
            FileWriter fileWriter = new FileWriter("teste.txt");
            fileWriter.write(questions.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
