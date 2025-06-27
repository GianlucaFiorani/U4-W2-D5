package gianlucafiorani.exceptions;

public class GameAddException extends RuntimeException {
    public GameAddException() {
        super("Gipoco già aggiunto");
    }
}
