package Ex1;

public class noGiftsLeftException extends RuntimeException {
    public noGiftsLeftException(String message) {
        super(message);
    }
}
