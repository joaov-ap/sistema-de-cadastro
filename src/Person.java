import java.util.List;

public class Person {
    private String name;
    private String email;
    private int age;
    private double height;
    private List<String> userAnswer;

    public Person() {
    }

    public Person(String name, String email, int age, double height) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.height = height;
    }

    public Person(String name, String email, int age, double height, List<String> userAnswer) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.height = height;
        this.userAnswer = userAnswer;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public List<String> getUserAnswer() {
        return userAnswer;
    }

    public String showNewAnswers() {
        String teste = "";
        for (String s : getUserAnswer()) {
            teste = s;
        }
        return teste;
    }

    @Override
    public String toString() {
        if (getUserAnswer() == null) {
            return getName() + "\n" + getEmail() + "\n" + getAge() + "\n" + getHeight();
        }
        return getName() + "\n" + getEmail() + "\n" + getAge() + "\n" + getHeight() + "\n" + showNewAnswers();
    }
}
