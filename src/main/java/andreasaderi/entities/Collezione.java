package andreasaderi.entities;

import java.util.List;

public class Collezione {
    private List<Gioco> games;

    public void addGame(Gioco game) {
        if (games.stream().anyMatch(giocoInLista -> giocoInLista.id == game.id)) {
            return;
        } else {
            games.add(game);
        }
    }

}
