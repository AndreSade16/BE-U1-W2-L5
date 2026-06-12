package andreasaderi;

import andreasaderi.entities.Collezione;
import andreasaderi.entities.Gioco;
import andreasaderi.entities.GiocoDaTavolo;
import andreasaderi.entities.Videogioco;
import andreasaderi.entities.enums.Genre;
import andreasaderi.entities.enums.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        10 Giochi:

        Gioco videogioco1 = new Videogioco("Expedition 33", 2026, 59.99, List.of(Platform.PLAYSTATION, Platform.PC), 10.5, Genre.RPG);
        Gioco videogioco2 = new Videogioco("Doom Eternal", 2020, 39.99, List.of(Platform.PC, Platform.XBOX), 15.0, Genre.FPS);
        Gioco videogioco3 = new Videogioco("Resident Evil 4", 2023, 49.99, List.of(Platform.PLAYSTATION, Platform.PC, Platform.XBOX), 18.0, Genre.HORROR);
        Gioco videogioco4 = new Videogioco("Street Fighter 6", 2023, 59.99, List.of(Platform.PLAYSTATION, Platform.PC), 25.0, Genre.BRAWLER);
        Gioco giocoDaTavolo1 = new GiocoDaTavolo("Indovina Chi", 1995, 39, 2, 20);
        Gioco giocoDaTavolo2 = new GiocoDaTavolo("Risiko", 1957, 35, 6, 180);
        Gioco giocoDaTavolo3 = new GiocoDaTavolo("Ticket to Ride", 2004, 45, 5, 60);
        Gioco giocoDaTavolo4 = new GiocoDaTavolo("Monopoli", 1980, 30, 4, 200);
        Gioco giocoDaTavolo5 = new GiocoDaTavolo("Pandemic", 2008, 42, 4, 60);

        List<Gioco> allTheGames = new ArrayList<>(List.of(videogioco1, videogioco2, videogioco3, videogioco4, giocoDaTavolo1, giocoDaTavolo2, giocoDaTavolo3, giocoDaTavolo4, giocoDaTavolo5));
        System.out.println("All the games: " + allTheGames);


//        Collezioni:

        Collezione collezione1 = new Collezione();

//        Prova dei metodi:

//        collezione1.addGame(videogioco1);
//        collezione1.addGame(videogioco2);
//        collezione1.addGame(videogioco4);
//        collezione1.addGame(giocoDaTavolo1);
//        collezione1.addGame(giocoDaTavolo2);
//        System.out.println(collezione1);
//        collezione1.searchById(3).ifPresent(System.out::println);
//        collezione1.searchById(1).ifPresent(System.out::println);
//        System.out.println(collezione1.searchByPrice(30));
//        System.out.println(collezione1.searchByPlayers(2));
//        collezione1.removeGame(5);
//        System.out.println(collezione1.searchByPlayers(2));
//        collezione1.updateGame(1, giocoDaTavolo3);
//        System.out.println(collezione1);
//        collezione1.printCollectionStats();


//        Interazione utente:
        while (true) {
            System.out.println("\nInserisci il numero corrispondente e premi invio (inserisci 0 per uscire)");
            int input = -1;
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato errato, inserisci un numero!");
                continue;
            }
            if (input == 0) break;
            switch (input) {
                case 1: {
                    System.out.println("Hai digitato 1");
                    break;
                }
                case 2: {
                    System.out.println("Hai digitato 2");
                    break;
                }
                default:
                    System.out.println("Input non valido");
            }
        }

    }
}
