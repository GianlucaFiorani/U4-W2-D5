package gianlucafiorani.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class Game {
    private final long id;
    private final Set<Long> idList = new HashSet<>();
    private String title;
    private int relaceDate;
    private double price;

    public Game(String title, int relaceDate, double price) {
        if (relaceDate < 1900 || relaceDate > LocalDate.now().getYear()) throw new RuntimeException("errore");
        else {
            long id;
            while (true) {
                Random rnd = new Random();
                id = rnd.nextLong();
                if (idList.add(id)) {
                    break;
                }
            }
            this.id = id;
            this.title = title;
            this.relaceDate = relaceDate;
            this.price = price;
        }
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRelaceDate() {
        return relaceDate;
    }

    public void setRelaceDate(int relaceDate) {
        if (relaceDate < 1900 || relaceDate > LocalDate.now().getYear()) throw new RuntimeException("errore");
        else this.relaceDate = relaceDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

