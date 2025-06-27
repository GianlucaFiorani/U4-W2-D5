package gianlucafiorani.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Non Trovato");
    }
}
