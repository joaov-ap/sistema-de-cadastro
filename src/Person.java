import java.util.List;

public class Person {
    private String name;
    private String email;
    private int age;
    private String height;
    private List<String> userAnswer;

    public Person() {
    }

    public Person(String name, String email, int age, String height) {
        this.name = name;
        if (name.length() < 10) {
            throw new NameLengthError("Nome deve possuir no mínimo 10 caracteres");
        }
        this.email = email;
        if (!email.contains("@")) {
            throw new EmailError("O email deve possuir obrigatoriamente o caracter @");
        }
        this.age = age;
        if (age < 18) {
            throw new UnderAgeError("O usuario deve ter mais de 18 anos");
        }
        this.height = height;
        if (height.contains(".")) {
            throw new HeightCharacterError("A altura deverá ser sempre o número com virgulas");
        }
    }

    public Person(String name, String email, int age, String height, List<String> userAnswer) {
        this(name, email, age, height);
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

    public String getHeight() {
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
        return (getUserAnswer() == null) ? getName() + "\n" + getEmail() + "\n" + getAge() + "\n" + getHeight() :
                getName() + "\n" + getEmail() + "\n" + getAge() + "\n" + getHeight() + "\n" + showNewAnswers();
    }
}
