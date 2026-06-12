package andreasaderi;

import andreasaderi.entities.Collezione;
import andreasaderi.entities.Gioco;
import andreasaderi.entities.GiocoDaTavolo;
import andreasaderi.entities.Videogioco;
import andreasaderi.entities.enums.Genre;
import andreasaderi.entities.enums.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        10 Giochi:

//        Gioco videogioco1 = new Videogioco("Expedition 33", 2026, 59.99, List.of(Platform.PLAYSTATION, Platform.PC), 10.5, Genre.RPG);
//        Gioco videogioco2 = new Videogioco("Doom Eternal", 2020, 39.99, List.of(Platform.PC, Platform.XBOX), 15.0, Genre.FPS);
//        Gioco videogioco3 = new Videogioco("Resident Evil 4", 2023, 49.99, List.of(Platform.PLAYSTATION, Platform.PC, Platform.XBOX), 18.0, Genre.HORROR);
//        Gioco videogioco4 = new Videogioco("Street Fighter 6", 2023, 59.99, List.of(Platform.PLAYSTATION, Platform.PC), 25.0, Genre.BRAWLER);
//        Gioco giocoDaTavolo1 = new GiocoDaTavolo("Indovina Chi", 1995, 39, 2, 20);
//        Gioco giocoDaTavolo2 = new GiocoDaTavolo("Risiko", 1957, 35, 6, 180);
//        Gioco giocoDaTavolo3 = new GiocoDaTavolo("Ticket to Ride", 2004, 45, 5, 60);
//        Gioco giocoDaTavolo4 = new GiocoDaTavolo("Monopoli", 1980, 30, 4, 200);
//        Gioco giocoDaTavolo5 = new GiocoDaTavolo("Pandemic", 2008, 42, 4, 60);

        List<Gioco> allTheGames = new ArrayList<>(List.of(new Videogioco("Expedition 33", 2026, 59.99, List.of(Platform.PLAYSTATION, Platform.PC), 10.5, Genre.RPG),
                new Videogioco("Doom Eternal", 2020, 39.99, List.of(Platform.PC, Platform.XBOX), 15.0, Genre.FPS),
                new Videogioco("Resident Evil 4", 2023, 49.99, List.of(Platform.PLAYSTATION, Platform.PC, Platform.XBOX), 18.0, Genre.HORROR),
                new Videogioco("Street Fighter 6", 2023, 59.99, List.of(Platform.PLAYSTATION, Platform.PC), 25.0, Genre.BRAWLER),
                new GiocoDaTavolo("Indovina Chi", 1995, 39, 2, 20),
                new GiocoDaTavolo("Risiko", 1957, 35, 6, 180),
                new GiocoDaTavolo("Ticket to Ride", 2004, 45, 5, 60),
                new GiocoDaTavolo("Monopoli", 1980, 30, 4, 200),
                new GiocoDaTavolo("Pandemic", 2008, 42, 4, 60)));

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
            System.out.println("Lista giochi: " + "\n");
            allTheGames.forEach(gioco -> System.out.println(gioco.getTitle() + " - ID: " + gioco.getId() + " - Prezzo: " + gioco.getPrice() + "€" + " - " + gioco.getClass().getSimpleName()));
            System.out.println("\nInserisci il numero corrispondente e premi invio (inserisci 0 per uscire)");
            System.out.println("\n1. Aggiungi gioco alla tua Collezione.");
            System.out.println("\n2. Cerca nella tua Collezione per ID.");
            System.out.println("\n3. Filtra per prezzo massimo.");
            System.out.println("\n");
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
                    while (true) {
                        long idToAdd = -1;
                        System.out.println("\nInserisci l'ID del gioco da aggiungere, poi premi invio. (0 per uscire)");
                        try {
                            idToAdd = Long.parseLong(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Formato errato, inserisci un ID valido");
                            continue;
                        }
                        if (idToAdd == 0) break;
                        else {
                            long finalIdToAdd = idToAdd;
                            Optional<Gioco> optGameToAdd = allTheGames.stream().filter(gioco -> gioco.getId() == finalIdToAdd).findFirst();
                            if (optGameToAdd.isEmpty()) {
                                System.out.println("ID non trovato.");
                            } else {
                                collezione1.addGame(optGameToAdd.get());
                                System.out.println(optGameToAdd.get().getTitle() + " aggiunto alla Collezione.");
                            }
                        }

                    }

                    break;
                }


                case 2: {
                    System.out.println("Inserisci l'ID da cercare: ");
                    while (true) {
                        long idToSearch = -1;
                        System.out.println("\nInserisci l'ID del gioco da cercare, poi premi invio. (0 per uscire)");
                        try {
                            idToSearch = Long.parseLong(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Formato errato, inserisci un ID valido");
                            continue;
                        }
                        if (idToSearch == 0) break;
                        else {
                            long finalIdToSearch = idToSearch;
                            Optional<Gioco> optGameToSearch = allTheGames.stream().filter(gioco -> gioco.getId() == finalIdToSearch).findFirst();
                            if (optGameToSearch.isEmpty()) {
                                System.out.println("ID non trovato.");
                            } else {
                                collezione1.addGame(optGameToSearch.get());
                                System.out.println("Risultato ricerca: " + optGameToSearch.get().getTitle() + " - ID: " + optGameToSearch.get().getId());
                            }
                        }

                    }
                    break;
                }

                case 3: {
                    while (true) {
                        double maxPrice = -1;
                        System.out.println("\nInserisci il prezzo massimo (0 per uscire)");
                        try {
                            maxPrice = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Formato errato, inserisci un numero");
                            continue;
                        }
                        if (maxPrice == 0) break;
                        else {
                            System.out.println("Lista dei giochi che costano meno di " + maxPrice + "€.\n" + collezione1.searchByPrice(maxPrice));
                            ;
                        }

                    }
                    break;
                }

                default:
                    System.out.println("Input non valido");
            }
        }

    }
}
