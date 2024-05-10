import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonRegistration {
    public void addPersonToTxt(int i, Person person) {
        try {
            FileWriter fileWriter = new FileWriter(i + " - " + person.getName().toUpperCase().replace(" ", "") + ".txt");
            fileWriter.write(person.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void questionsReader(List<String> questions) {
        try {
            FileReader file = new FileReader("formulario.txt");
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

    public void register(List<Person> personList, PersonRegistration personRegistration) {
        Scanner sc = new Scanner(System.in);
        List<String> questions = new ArrayList<>();
        List<String> userAnswer = new ArrayList<>();
        personRegistration.questionsReader(questions);

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
        personRegistration.addPersonToTxt(personList.size(), person);
        userAnswer.clear();
    }
}
