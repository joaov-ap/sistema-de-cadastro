public class NameLengthError extends RuntimeException {
    private String errorMessage;

    public NameLengthError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }
}
