public class EmailError extends RuntimeException {
    private String errorMessage;

    public EmailError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }
}
