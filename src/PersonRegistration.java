import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonRegistration {
    private static final String FORMS_FILE = "formulario.txt";
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
        Scanner sc = new Scanner(System.in);

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
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a pergunta a ser adicionada ao formulario: ");
        String userQuestion = sc.nextLine();
        questions.add((questions.size() + 1) + " - " + userQuestion + "?");

        try {
            FileWriter fileWriter = new FileWriter(FORMS_FILE, true);
            fileWriter.write("\n" + questions.get(questions.size() - 1));
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeNewQuestions(List<String> questions) {
        Scanner sc = new Scanner(System.in);
        questions.forEach(System.out::println);
        System.out.print("Digite o numero da pergunta a ser removida do formulario: ");
        int questionIndex = sc.nextInt();

        if (questionIndex != 0 || questionIndex != 1 || questionIndex != 2 || questionIndex != 3) {
            System.out.print("Voce realmente deseja excluir a pergunta: ");
            System.out.println('"' + questions.get(questionIndex-1) + '"');
            System.out.println("1 - Sim\n2 - Nao");
            int confirm = sc.nextInt();

            if (confirm != 1 || confirm != 2){
                System.out.println("Escolha entre 1 e 2!");
            }
        }
    }
}
