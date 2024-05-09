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
}
