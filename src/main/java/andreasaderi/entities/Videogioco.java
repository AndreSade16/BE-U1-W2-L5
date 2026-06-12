package andreasaderi.entities;

import andreasaderi.entities.enums.Genre;
import andreasaderi.entities.enums.Platform;

import java.util.List;

public class Videogioco extends Gioco {
    private List<Platform> platform;
    private double duration;
    private Genre genre;

    public Videogioco(String title, int publishedYear, double price, List<Platform> platform, double duration, Genre genre) {
        super(title, publishedYear, price);
        this.platform = platform;
        this.duration = duration;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Videogioco{" +
                "id=" + id +
                ", title=" + title +
                ", published in=" + publishedYear +
                ", price=" + price +
                ", platform=" + platform +
                ", duration=" + duration +
                ", genre=" + genre +
                '}';
    }
}
