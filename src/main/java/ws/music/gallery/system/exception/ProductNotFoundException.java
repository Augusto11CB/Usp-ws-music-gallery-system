package ws.music.gallery.system.exception;


public class ProductNotFoundException extends RuntimeException {

    String[] args;


    public ProductNotFoundException(Exception ex) {
        super(ex);
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Exception ex) {
        super(message, ex);
    }

    public ProductNotFoundException(String message, String... args) {
        super(message);
        this.args = args;
    }
}
