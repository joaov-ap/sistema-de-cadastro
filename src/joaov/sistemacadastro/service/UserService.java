package joaov.sistemacadastro.service;

import joaov.sistemacadastro.model.User;

import java.util.List;
import java.util.Scanner;

public class UserService {
    private Scanner scanner = new Scanner(System.in);
    private RegisterService registerService;

    public UserService(RegisterService registerService) {
        this.registerService = registerService;
    }

    public void showUsers() {
        int totalUsers = registerService.getUsers().size();
        for (int i = 0; i < totalUsers; i++) {
            System.out.println(i+1 + " - " + registerService.getUsers().get(i).getName());
        }
        System.out.println();
    }

    public void searchUser() {
        List<User> userList;
        System.out.print("Digite o nome, idade ou email: ");
        String args = scanner.nextLine().toUpperCase();
        if (isNumber(args)) {
            userList = registerService.getUsers().stream().filter(u -> u.getAge() == Byte.parseByte(args)).toList();
        } else {
            userList = registerService.getUsers().stream().filter(u -> u.getName().toUpperCase().contains(args) || u.getEmail().toUpperCase().contains(args)).toList();
        }
        System.out.print("Cadastrados: ");
        for (int i = 0; i < userList.size(); i++) {
            if (!(i+1 == userList.size())) {
                System.out.print(userList.get(i).getName() + ", ");
            } else {
                System.out.print(userList.get(i).getName());
            }
        }
        System.out.println();
    }

    private boolean isNumber(String str) {
        try {
            Byte.parseByte(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
