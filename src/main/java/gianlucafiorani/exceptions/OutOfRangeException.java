package gianlucafiorani.exceptions;

public class OutOfRangeException extends RuntimeException {
    public OutOfRangeException() {
        super("Numero inserito fuori dal range");
    }
}
