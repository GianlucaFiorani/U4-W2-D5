package gianlucafiorani.entities;

import gianlucafiorani.entities.enums.Genre;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;

public class Collection {
    private final List<Game> collection;

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
        try {
            while (true) {
                if (edit instanceof VideoGame editV) {
                    System.out.println(editMessage
                            + " 4-Piattaforma: " + editV.getPlatform()
                            + " 5-Durata di gioco: " + editV.getDuration() + " ore"
                            + " 6-Genere: " + editV.getGenre());
                    int selected = Integer.parseInt(scanner.nextLine());
                    switch (selected) {
                        case 0 -> System.out.println("Esco...");
                        case 1 -> {
                            System.out.println("Inserisci nuovo titolo:");
                            String title = scanner.nextLine();
                            editV.setTitle(title);
                        }
                        case 2 -> {
                            System.out.println("Inserisci nuovo anno pubblicazione:");
                            int year = Integer.parseInt(scanner.nextLine());
                            editV.setRelaceDate(year);
                        }
                        case 3 -> {
                            System.out.println("Inserisci nuovo prezzo:");
                            double price = Double.parseDouble(scanner.nextLine());
                            editV.setPrice(price);
                        }
                        case 4 -> {
                            System.out.println("Inserisci nuova piattaforma:");
                            String platform = scanner.nextLine();
                            editV.setPlatform(platform);
                        }
                        case 5 -> {
                            System.out.println("Inserisci nuovoa durata, in ore:");
                            int duration = Integer.parseInt(scanner.nextLine());
                            editV.setDuration(duration);
                        }
                        case 6 -> {
                            System.out.println("Seleziona un genere (seleziona 0 per uscire ):  1-FPS 2-ACTION 3-PLATFORM 4-MOBA 5-RACING 6-RPG ");
                            int genreSelected = Integer.parseInt(scanner.nextLine());
                            switch (genreSelected) {
                                case 0 -> System.out.println("Esco...");
                                case 1 -> editV.setGenre(Genre.FPS);
                                case 2 -> editV.setGenre(Genre.ACTION);
                                case 3 -> editV.setGenre(Genre.PLATFORM);
                                case 4 -> editV.setGenre(Genre.MOBA);
                                case 5 -> editV.setGenre(Genre.RACING);
                                case 6 -> editV.setGenre(Genre.RPG);
                                default -> System.out.println("Selezionato genere inesistente");
                            }
                        }
                        default -> System.out.println("Selezionato componente inesistente");

                    }
                } else {
                    BoardGame editB = (BoardGame) edit;
                    System.out.println(editMessage
                            + " 4-Numero di giocatori: " + editB.getPlayerNum()
                            + " 5-Durata media partita: " + editB.getDuration() + " minuti");
                    int selected = Integer.parseInt(scanner.nextLine());
                    switch (selected) {
                        case 0 -> System.out.println("Esco...");
                        case 1 -> {
                            System.out.println("Inserisci nuovo titolo:");
                            String title = scanner.nextLine();
                            editB.setTitle(title);
                        }
                        case 2 -> {
                            System.out.println("Inserisci nuovo anno pubblicazione:");
                            int year = Integer.parseInt(scanner.nextLine());
                            editB.setRelaceDate(year);
                        }
                        case 3 -> {
                            System.out.println("Inserisci nuovo prezzo:");
                            double price = Double.parseDouble(scanner.nextLine());
                            editB.setPrice(price);
                        }
                        case 4 -> {
                            System.out.println("Inserisci nuovo numero di giocatori:");
                            int playerNum = Integer.parseInt(scanner.nextLine());
                            editB.setPlayerNum(playerNum);
                        }
                        case 5 -> {
                            System.out.println("Inserisci nuova durata medi, in  minuti:");
                            int duration = Integer.parseInt(scanner.nextLine());
                            editB.setDuration(duration);
                        }
                        default -> System.out.println("Selezionato componente inesistente");
                    }
                }
                System.out.println("Vuoi modificare altri parametri? Y/N: ");
                String response = scanner.nextLine();
                if (!response.equals("y")) {
                    scanner.close();
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Non hai inserito un numero");
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
