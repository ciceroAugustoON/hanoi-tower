package game.exception;

public class InvalidLineException extends Exception {
    @Override
    public String getMessage() {
        return "This line doesn't exists";
    }
}
