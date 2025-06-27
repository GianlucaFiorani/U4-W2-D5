package gianlucafiorani.entities;

import java.time.LocalDate;

public class BoardGame extends Game {
    private final int playerNum;
    private final int duration;

    public BoardGame(String title, LocalDate relaceDate, double price, int playerNum, int duration) {
        super(title, relaceDate, price);
        this.playerNum = playerNum;
        this.duration = duration;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public int getDuration() {
        return duration;
    }
}
