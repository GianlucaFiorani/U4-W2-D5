package gianlucafiorani;

import gianlucafiorani.entities.BoardGame;
import gianlucafiorani.entities.Collection;
import gianlucafiorani.entities.Game;
import gianlucafiorani.entities.VideoGame;
import gianlucafiorani.entities.enums.Genre;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Collection collection = new Collection();
        Game newgame = new VideoGame("bubba", 1700, 15, "ps5", 15, Genre.FPS);
        collection.addGame(newgame);
        collection.collectionStats();
    }

    public static void createGame(Collection collection) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Seleziona 1 per creare Videogame, seleziona 2 per creare gioco da tavolo, seleziona 0 per uscire: ");
            int gameType = Integer.parseInt(scanner.nextLine());
            switch (gameType) {
                case 0 -> System.out.println("Esco...");
                case 1 -> {

                    System.out.println("Inserisci nuovo titolo:");
                    String title = scanner.nextLine();

                    System.out.println("Inserisci nuovo anno pubblicazione:");
                    int year = Integer.parseInt(scanner.nextLine());

                    System.out.println("Inserisci nuovo prezzo:");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.println("Inserisci nuova piattaforma:");
                    String platform = scanner.nextLine();

                    System.out.println("Inserisci nuovoa durata, in ore:");
                    int duration = Integer.parseInt(scanner.nextLine());

                    System.out.println("Seleziona un genere:  1-FPS 2-ACTION 3-PLATFORM 4-MOBA 5-RACING 6-RPG ");
                    int genreSelected = Integer.parseInt(scanner.nextLine());
                    Genre genre;
                    switch (genreSelected) {
                        case 1 -> genre = Genre.FPS;
                        case 2 -> genre = Genre.ACTION;
                        case 3 -> genre = Genre.PLATFORM;
                        case 4 -> genre = Genre.MOBA;
                        case 5 -> genre = Genre.RACING;
                        case 6 -> genre = Genre.RPG;
                        default -> throw new RuntimeException("errore");
                    }
                    collection.addGame(new VideoGame(title, year, price, platform, duration, genre));
                }
                case 2 -> {
                    System.out.println("Inserisci nuovo titolo:");
                    String title = scanner.nextLine();

                    System.out.println("Inserisci nuovo anno pubblicazione:");
                    int year = Integer.parseInt(scanner.nextLine());

                    System.out.println("Inserisci nuovo prezzo:");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.println("Inserisci nuovo numero di giocatori:");
                    int playerNum = Integer.parseInt(scanner.nextLine());

                    System.out.println("Inserisci nuova durata medi, in  minuti:");
                    int duration = Integer.parseInt(scanner.nextLine());

                    collection.addGame(new BoardGame(title, year, price, playerNum, duration));

                }
                default -> System.out.println("Numero non corrispondente alle opzioni");
            }
        } catch (NumberFormatException e) {
            System.out.println("Non hai inserito un numero");
        }
    }
}
