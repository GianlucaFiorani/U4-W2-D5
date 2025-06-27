package gianlucafiorani.entities;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;

public class Collection {
    private List<Game> collection;

    public Collection() {
        this.collection = new ArrayList<>();
    }

    public void addGame(Game game) {
        this.collection.add(game);
    }

    public void addGame(List<Game> game) {
        this.collection.addAll(game);
    }

    public void removeGame(long id) {
        Game gameToRemove = getGame(id);
        this.collection.remove(gameToRemove);
    }

    public Game getGame(long id) {
        List<Game> result = this.collection.stream().filter(game -> game.getId() == id).toList();
        if (result.isEmpty()) {
            throw new RuntimeException("Non trovato");
        } else return result.getFirst();
    }

    public void editGame(long id) {
        Game edit = getGame(id);
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------- EDIT MODE ------------------------------------");

        String editMessage = "Seleziona componente da editare (seleziona 0 per uscire) : "
                + " 1-Titolo: " + edit.getTitle()
                + " 2-Anno Pubblicazione: " + edit.getRelaceDate()
                + " 3-Prezzo: " + edit.getPrice();

        if (edit instanceof VideoGame editV) {
            System.out.println(editMessage
                    + " 4-Piattaforma: " + editV.getPlatform()
                    + " 5-Durata di gioco: " + editV.getDuration() + " ore"
                    + " 6-Genere: " + editV.getGenre());
            int selected = Integer.parseInt(scanner.nextLine());
            switch (selected) {
                case 1: {
                    System.out.println("Inserisci nuovo titolo:");
                    String title = scanner.nextLine();
                    editV.setTitle(title);
                    break;
                }
                case 2: {
                    System.out.println("Inserisci nuovo anno pubblicazione:");
                    String title = scanner.nextLine();
                    editV.setTitle(title);
                }
                case 3: {
                    System.out.println("Inserisci nuovo titolo:");
                    String title = scanner.nextLine();
                    editV.setTitle(title);
                }

            }


        } else {
            BoardGame editB = (BoardGame) edit;
            System.out.println(editMessage
                    + " 4-Numero di giocatori: " + editB.getPlayerNum()
                    + " 5-Durata media partita: " + editB.getDuration() + " minuti");

        }
    }

    public List<Game> searchByPrice(double price) {
        List<Game> result = this.collection.stream().filter(game -> game.getPrice() < price).toList();
        if (result.isEmpty()) {
            throw new RuntimeException("Non trovato");
        } else return result;
    }

    public List<Game> searchByPlayerNum(int playerNum) {
        List<Game> result = this.collection.stream().filter(game -> game instanceof BoardGame && ((BoardGame) game).getPlayerNum() < playerNum).toList();
        if (result.isEmpty()) {
            throw new RuntimeException("Non trovato");
        } else return result;
    }

    public void collectionStats() {
        int videoGameNum = this.collection.stream().filter(game -> game instanceof VideoGame).toList().size();
        DoubleSummaryStatistics stats = this.collection.stream().mapToDouble(game -> game.getPrice()).summaryStatistics();
        System.out.println(
                " Videogiochi: " + videoGameNum
                        + " Giochi da tavolo: " + (this.collection.size() - videoGameNum)
                        + " Gioco con il prezzo più alto: " + stats.getMax()
                        + " Media dei prezzi: " + stats.getAverage());
    }

}
