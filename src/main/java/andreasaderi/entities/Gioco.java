package andreasaderi.entities;

public abstract class Gioco {
    private static int numOfGames = 0;
    protected long id;
    private String title;
    private int publishedYear;
    private int price;

    public Gioco(String title, int publishedYear, int price) {
        this.id = ++numOfGames;
        this.title = title;
        this.publishedYear = publishedYear;
        this.price = price;
    }
}
