package gianlucafiorani.entities;

import gianlucafiorani.entities.enums.Genre;

import java.time.LocalDate;

public class VideoGame extends Game {
    private final String platform;
    private final int duration;
    private final Genre genre;


    public VideoGame(String title, LocalDate relaceDate, double price, String platform, int duration, Genre genre) {
        super(title, relaceDate, price);
        this.platform = platform;
        this.duration = duration;
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public int getDuration() {
        return duration;
    }

    public Genre getGenre() {
        return genre;
    }
}
