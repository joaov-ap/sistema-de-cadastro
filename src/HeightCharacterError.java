public class HeightCharacterError extends RuntimeException{
    private String errorMessage;

    public HeightCharacterError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }
}
