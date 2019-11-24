package ws.music.gallery.system.exception;


public class UserNotFoundException extends RuntimeException {

    String[] args;


    public UserNotFoundException(Exception ex) {
        super(ex);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Exception ex) {
        super(message, ex);
    }

    public UserNotFoundException(String message, String... args) {
        super(message);
        this.args = args;
    }
}
