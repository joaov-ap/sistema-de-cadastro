package joaov.sistemacadastro.exceptions;

public class LessThanEighteenException extends RuntimeException{
    public LessThanEighteenException() {
        super("Idade inválida: Usuário deve ter mais de 18 anos");
    }
}
