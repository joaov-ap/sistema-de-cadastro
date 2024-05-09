import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PersonRegistration {
    public void addPersonToTxt(int i, Person person) {
        try {
            FileWriter fileWriter = new FileWriter((i+1) + " - " + person.getName().toUpperCase().replace(" ", "") + ".txt");
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
        int i = 0;
        for (Person person : personList) {
            System.out.println((i+1) + " - " + person.getName());
            i++;
        }
    }

    public void register(List<String> questions, List<String> userAnswer, List<Person> personList, PersonRegistration personRegistration) {
        Scanner sc = new Scanner(System.in);
        personRegistration.questionsReader(questions);

        int i = 0;
        while (i < questions.size()) {
            System.out.println(questions.get(i));
            String answer = sc.nextLine();
            userAnswer.add(answer);
            i++;
        }

        String name = userAnswer.get(0);
        String email = userAnswer.get(1);
        int age = Integer.parseInt(userAnswer.get(2));
        double height = Double.parseDouble(userAnswer.get(3));

        Person person = new Person(name, email, age, height);
        personList.add(person);
        personRegistration.addPersonToTxt(personList.size(), person);
    }

}
