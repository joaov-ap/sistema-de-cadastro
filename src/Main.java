import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> questions = new ArrayList<>();

        try {
            FileReader file = new FileReader("formulario.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                questions.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(questions.get(0));
        System.out.println(questions.get(1));
        System.out.println(questions.get(2));
        System.out.println(questions.get(3));
    }
}
