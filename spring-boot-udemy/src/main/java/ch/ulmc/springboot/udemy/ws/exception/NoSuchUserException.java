package ch.ulmc.springboot.udemy.ws.exception;

public class NoSuchUserException extends RuntimeException {
    private static final long serialVersionUID = 7034897890715266639L;
    
    public NoSuchUserException(String message) {
        super(message);
    }
}
