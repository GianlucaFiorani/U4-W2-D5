package gianlucafiorani.entities;

import java.time.LocalDate;
import java.util.Random;

public class Game {
    protected final long id;
    protected final String title;
    protected final LocalDate relaceDate;
    protected double price;

    public Game(String title, LocalDate relaceDate, double price) {
        Random rnd = new Random();
        this.id = rnd.nextLong();
        this.title = title;
        this.relaceDate = relaceDate;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getRelaceDate() {
        return relaceDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

