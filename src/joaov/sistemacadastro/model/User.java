package joaov.sistemacadastro.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private byte age;
    private double height;
    private List<String> newAnswers;

    public User() {
    }

    public User(String name, String email, byte age, double height) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.height = height;
        this.newAnswers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public byte getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public List<String> getNewAnswers() {
        return newAnswers;
    }

    @Override
    public String toString() {
        return name + "\n" +
                email + "\n" +
                age  + "\n" +
                height;
    }
}
