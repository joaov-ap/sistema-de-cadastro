package joaov.sistemacadastro.exceptions;

public class EmailException extends RuntimeException{
    public EmailException() {
        super("Email inválido: Email deve conter '@'");
    }

    public EmailException(String message) {
        super(message);
    }
}
