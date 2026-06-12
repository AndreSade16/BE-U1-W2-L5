package andreasaderi.entities;

import andreasaderi.entities.enums.Genre;
import andreasaderi.entities.enums.Platform;

public class Videogioco extends Gioco {
    private Platform platform;
    private int duration;
    private Genre genre;

    public Videogioco(String title, int publishedYear, int price, Platform platform, int duration, Genre genre) {
        super(title, publishedYear, price);
        this.platform = platform;
        this.duration = duration;
        this.genre = genre;
    }

}
