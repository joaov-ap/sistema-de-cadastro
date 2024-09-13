package joaov.sistemacadastro.view;

import joaov.sistemacadastro.service.FormsService;
import joaov.sistemacadastro.service.RegisterService;
import joaov.sistemacadastro.service.UserService;

import java.util.Scanner;

public class AppStart {
    private Scanner scanner = new Scanner(System.in);
    private RegisterService registerService = new RegisterService();
    private UserService userService = new UserService(registerService);
    private FormsService formsService = new FormsService(registerService);

    public void run() {
        int userOption = -1;
        while (userOption != 0) {
            menu();
            userOption = scanner.nextInt();
            scanner.nextLine();
            switch (userOption) {
                case 1:
                    registerService.doQuestions();
                    break;
                case 2:
                    userService.showUsers();
                    break;
                case 3:
                    formsService.addQuestionToForms();
                    break;
                case 4:
                    formsService.deleteQuestion();
                    break;
                case 5:
                    userService.searchUser();
                    break;
            }
        }
    }

    private void menu() {
        System.out.println("""
                1 - Cadastrar o usuário
                2 - Listar todos usuários cadastrados
                3 - Cadastrar nova pergunta no formulário
                4 - Deletar pergunta do formulário
                5 - Pesquisar usuário por nome ou idade ou email
                """);
    }
}
