package andreasaderi.entities;

import java.util.*;

public class Collezione {
    private final List<Gioco> games;

    public Collezione() {
        this.games = new ArrayList<>();
    }

    public void addGame(Gioco game) {
        if (games.stream().anyMatch(giocoInLista -> giocoInLista.id == game.id)) {
            System.out.println("Gioco/ID già esistente");
        } else {
            games.add(game);
        }
    }

    public Optional<Gioco> searchById(long id) {
        Optional<Gioco> result = games.stream().filter(gioco -> gioco.id == id).findFirst();

        if (result.isEmpty()) System.out.println("\nId non trovato: " + id);
        return result;
    }

    public List<Gioco> searchByPrice(double price) {
        return games.stream().filter(gioco -> gioco.price < price).toList();
    }

    public List<GiocoDaTavolo> searchByPlayers(int players) {
        return games.stream().filter(gioco -> gioco instanceof GiocoDaTavolo game && game.numOfPlayers == players).map(gioco -> (GiocoDaTavolo) gioco).toList();
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
        if (optGame.isPresent()) {
            Gioco game = optGame.get();
            int index = games.indexOf(game);
            games.set(index, gameToAdd);
            System.out.println("Titolo: " + game.getTitle() + " - ID: " + game.getId());

        } else {
            System.out.println("ID non trovato.");
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

    @Override
    public String toString() {
        return "Collezione{" +
                "games=" + games +
                '}';
    }
}
