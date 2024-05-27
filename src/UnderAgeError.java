public class UnderAgeError extends RuntimeException {
    private String errorMessage;

    public UnderAgeError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }
}
