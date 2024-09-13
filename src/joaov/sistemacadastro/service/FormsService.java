package joaov.sistemacadastro.service;

import joaov.sistemacadastro.util.FileHandler;

import java.util.List;
import java.util.Scanner;

public class FormsService {
    private Scanner scanner = new Scanner(System.in);
    private RegisterService registerService;
    private List<String> newQuestions = FileHandler.formsReader(FileHandler.getTEMP_FILE());

    public FormsService(RegisterService registerService) {
        this.registerService = registerService;
    }

    public void addQuestionToForms() {
        System.out.print("Digite a pergunta que deseja adicionar: ");
        String newQuestion = scanner.nextLine();
        newQuestions.add(newQuestion);

        int index = registerService.getQuestions().size() + 1;
        registerService.getQuestions().add(index + " - " + newQuestion + "?");
        System.out.println("Pergunta: " + "'" + registerService.getQuestions().getLast() + "'" + " adicionada com sucesso.");
        FileHandler.formsWriter(registerService.getQuestions(), FileHandler.getFORMS_FILE());
        FileHandler.formsWriter(newQuestions, FileHandler.getTEMP_FILE());
        System.out.println();
    }

    public void deleteQuestion() {
        for (int i = 0; i < registerService.getQuestions().size(); i++) {
            System.out.println(registerService.getQuestions().get(i));
        }
        System.out.println();

        System.out.print("Digite o número da pergunta que deseja excluir: ");
        byte index = (byte) (scanner.nextByte() - 1);
        scanner.nextLine();

        if (registerService.getQuestions().size() == 4) {
            System.out.println("As 4 perguntas inicias não podem ser removidas!");
            return;
        }

        if (index != 0 && index != 1 && index != 2 && index != 3) {
            System.out.println("Pergunta: " + "'" + registerService.getQuestions().get(index) + "'" + " removida com sucesso.");
            registerService.getQuestions().remove(index);
        }

        for (int i = index; i < registerService.getQuestions().size(); i++) {
            registerService.getQuestions().add(i, (i + 1) + " - " + newQuestions.get(i + 1) + "?");
            registerService.getQuestions().remove(i + 1);
        }
        newQuestions.remove(index);


        FileHandler.formsWriter(newQuestions, FileHandler.getTEMP_FILE());
        FileHandler.formsWriter(registerService.getQuestions(), FileHandler.getFORMS_FILE());
        System.out.println();
    }
}
