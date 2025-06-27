package gianlucafiorani.entities;

import gianlucafiorani.entities.enums.Genre;

public class VideoGame extends Game {
    private String platform;
    private int duration;
    private Genre genre;


    public VideoGame(String title, int relaceDate, double price, String platform, int duration, Genre genre) {
        super(title, relaceDate, price);
        this.platform = platform;
        this.duration = duration;
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
