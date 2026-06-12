package andreasaderi.entities;

public abstract class Gioco {
    private static int numOfGames = 0;
    protected long id;
    protected String title;
    protected int publishedYear;
    protected double price;

    public Gioco(String title, int publishedYear, double price) {
        this.id = ++numOfGames;
        this.title = title;
        this.publishedYear = publishedYear;
        this.price = price >= 0 ? price : -price;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
