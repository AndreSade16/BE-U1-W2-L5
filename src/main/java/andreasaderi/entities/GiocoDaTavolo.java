package andreasaderi.entities;

public class GiocoDaTavolo extends Gioco {

    int numOfPlayers;
    private int avgDurationInMinutes;

    public GiocoDaTavolo(String title, int publishedYear, int price, int numOfPlayers, int avgDurationInMinutes) {
        super(title, publishedYear, price);
        this.numOfPlayers = numOfPlayers;
        this.avgDurationInMinutes = avgDurationInMinutes;
    }

    @Override
    public String toString() {
        return "\nGiocoDaTavolo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishedYear=" + publishedYear +
                ", price=" + price +
                ", numOfPlayers=" + numOfPlayers +
                ", avgDurationInMinutes=" + avgDurationInMinutes +
                '}';
    }
}
