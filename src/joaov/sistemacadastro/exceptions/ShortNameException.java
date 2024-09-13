package joaov.sistemacadastro.exceptions;

public class ShortNameException extends RuntimeException {
    public ShortNameException() {
        super("Nome inválido: Nome deve ter mais de 10 caracteres");
    }
}
