package andreasaderi.entities;

public class GiocoDaTavolo extends Gioco {

    private int numOfPlayers;
    private int avgDurationInMinutes;

    public GiocoDaTavolo(String title, int publishedYear, int price, int numOfPlayers, int avgDurationInMinutes) {
        super(title, publishedYear, price);
        this.numOfPlayers = numOfPlayers;
        this.avgDurationInMinutes = avgDurationInMinutes;
    }
    

}
