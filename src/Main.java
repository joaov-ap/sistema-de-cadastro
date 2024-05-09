import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonRegistration personRegistration = new PersonRegistration();
        List<Person> personList = new ArrayList<>();
        List<String> questions = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            personRegistration.questionsReader(questions);
            System.out.println(questions.get(0));
            String name = sc.nextLine();
            System.out.println(questions.get(1));
            String email = sc.next();
            System.out.println(questions.get(2));
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println(questions.get(3));
            double height = sc.nextDouble();
            sc.nextLine();

            Person person = new Person(name, email, age, height);
            personList.add(person);

            personRegistration.addPersonToTxt(i, person);
        }

        personList.forEach(System.out::println);

    }

    public void menu() {
        System.out.print("""
                1 - Cadastrar o usuário
                2 - Listar todos usuários cadastrados
                3 - Cadastrar nova pergunta no formulário
                4 - Deletar pergunta do formulário
                5 - Pesquisar usuário por nome ou idade ou email
                Escolha sua opção: 
                """);
    }
}
