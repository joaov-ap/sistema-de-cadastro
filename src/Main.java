import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonRegistration personRegistration = new PersonRegistration();
        List<Person> personList = new ArrayList<>();
        List<String> userAnswer = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int i = 0;
        while (i != 6) {
            menu();
            i = sc.nextInt();
            switch (i) {
                case 1:
                    personRegistration.register(userAnswer, personList, personRegistration);
                    System.out.println();
                    break;
                case 2:
                    personRegistration.addedPersonList(personList);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Saindo.....");
                    break;
                default:
                    System.out.println("Escolha invalida. Tente novamente!");
                    System.out.println();
                    break;
            }
        }
    }

    public static void menu() {
        System.out.print("""
                1 - Cadastrar o usuário
                2 - Listar todos usuários cadastrados
                3 - Cadastrar nova pergunta no formulário
                4 - Deletar pergunta do formulário
                5 - Pesquisar usuário por nome ou idade ou email
                6 - Sair
                Escolha sua opção: 
                """);
    }
}
