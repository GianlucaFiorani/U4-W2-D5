package gianlucafiorani.entities;

public class BoardGame extends Game {
    private int playerNum;
    private int duration;

    public BoardGame(String title, int relaceDate, double price, int playerNum, int duration) {
        super(title, relaceDate, price);
        if (playerNum > 10 || playerNum < 1) throw new RuntimeException("errore");
        else {
            this.playerNum = playerNum;
            this.duration = duration;
        }
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        if (playerNum > 10 || playerNum < 1) throw new RuntimeException("errore");
        else this.playerNum = playerNum;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
