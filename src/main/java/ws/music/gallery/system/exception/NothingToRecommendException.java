package ws.music.gallery.system.exception;

public class NothingToRecommendException extends RuntimeException {

    String[] args;


    public NothingToRecommendException(Exception ex) {
        super(ex);
    }

    public NothingToRecommendException(String message) {
        super(message);
    }

    public NothingToRecommendException(String message, Exception ex) {
        super(message, ex);
    }

    public NothingToRecommendException(String message, String... args) {
        super(message);
        this.args = args;
    }
}