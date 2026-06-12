package andreasaderi.entities;

import andreasaderi.entities.exceptions.GameNotFound;

import java.util.*;

public class Collezione {
    private final List<Gioco> games;

    public Collezione() {
        this.games = new ArrayList<>();
    }

    public void addGame(Gioco game) {
        if (games.stream().anyMatch(giocoInLista -> giocoInLista.id == game.id)) {
            System.out.println("Gioco/ID già presente nella collezione");
        } else {
            games.add(game);
        }
    }

    public Optional<Gioco> searchById(long id) {

        return games.stream().filter(gioco -> gioco.id == id).findFirst();
    }

    public List<Gioco> searchByPrice(double price) {
        List<Gioco> result = games.stream().filter(gioco -> gioco.price < price).toList();
        if (result.isEmpty()) throw new GameNotFound("Nessun gioco trovato");
        return result;
    }

    public List<GiocoDaTavolo> searchByPlayers(int players) {
        List<GiocoDaTavolo> result = games.stream().filter(gioco -> gioco instanceof GiocoDaTavolo game && game.numOfPlayers == players).map(gioco -> (GiocoDaTavolo) gioco).toList();
        if (result.isEmpty()) throw new GameNotFound("Nessun gioco trovato");
        return result;
    }

    public void removeGame(long id) {
        Optional<Gioco> game = games.stream().filter(gioco -> gioco.id == id).findFirst();
        if (game.isPresent()) {
            games.remove(game.get());
            System.out.println("Gioco rimosso");
        } else {
            System.out.println("Gioco non trovato.");
        }
    }


    public void updateGame(long id, Gioco gameToAdd) {
        Optional<Gioco> optGame = searchById(id);
        Optional<Gioco> gameAlreadyThere = searchById(gameToAdd.getId());
        if (gameAlreadyThere.isEmpty()) {
            if (optGame.isPresent()) {
                Gioco game = optGame.get();
                int index = games.indexOf(game);
                games.set(index, gameToAdd);
                System.out.println("Titolo: " + game.getTitle() + " - ID: " + game.getId() + " rimpiazzato con " + gameToAdd.getTitle() + " - ID: " + gameToAdd.getId());
            } else {
                System.out.println("ID non trovato.");
            }
        } else {
            System.out.println("Il gioco da inserire è già nella Collezione!");
        }
    }

    public void printCollectionStats() {
        OptionalDouble optAvg = games.stream().mapToDouble(Gioco::getPrice).average();
        Optional<Gioco> optMostExpensive = games.stream().sorted(Comparator.comparing(Gioco::getPrice).reversed()).limit(1).findFirst();
        if (optMostExpensive.isEmpty() || optAvg.isEmpty()) {
            System.out.println("La lista è vuota.");
        } else {
            System.out.println("Collection's size: " + games.size() +
                    "\nGioco con prezzo più alto: " + optMostExpensive.get() +
                    "\nMedia prezzi: " + optAvg.getAsDouble());
        }

    }

    public List<Gioco> getGames() {
        return games;
    }

    @Override
    public String toString() {
        return "Collezione{" +
                "games=" + games +
                '}';
    }
}
