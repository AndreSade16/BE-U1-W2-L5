package andreasaderi.entities;

import andreasaderi.entities.exceptions.GameNotFound;

import java.util.List;

public class Collezione {
    private List<Gioco> games;

    public void addGame(Gioco game) {
        if (games.stream().anyMatch(giocoInLista -> giocoInLista.id == game.id)) {
            System.out.println("Gioco/ID già esistente");
        } else {
            games.add(game);
        }
    }

    public Gioco searchById(long id) {
        return games.stream().filter(gioco -> gioco.id == id).findFirst().orElseThrow(() -> new GameNotFound("Id non trovato"));
    }


}
