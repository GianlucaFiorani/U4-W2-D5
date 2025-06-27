package gianlucafiorani;

import gianlucafiorani.entities.Game;
import gianlucafiorani.entities.VideoGame;
import gianlucafiorani.entities.enums.Genre;

public class Application {

    public static void main(String[] args) {
        Game newgame = new VideoGame("bubba", 1700, 15, "ps5", 15, Genre.FPS);
        System.out.println(newgame.getTitle());
    }
}
