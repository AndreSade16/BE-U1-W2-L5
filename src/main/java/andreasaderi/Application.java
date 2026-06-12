package andreasaderi;

import andreasaderi.entities.Collezione;
import andreasaderi.entities.Gioco;
import andreasaderi.entities.GiocoDaTavolo;
import andreasaderi.entities.Videogioco;
import andreasaderi.entities.enums.Genre;
import andreasaderi.entities.enums.Platform;
import andreasaderi.entities.exceptions.GameNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Gioco> allTheGames = new ArrayList<>(List.of(new Videogioco("Expedition 33", 2026, 39.99, List.of(Platform.PLAYSTATION, Platform.PC), 10.5, Genre.RPG),
                new Videogioco("Doom Eternal", 2020, 19.99, List.of(Platform.PC, Platform.XBOX), 15.0, Genre.FPS),
                new Videogioco("Resident Evil 4", 2023, 49.99, List.of(Platform.PLAYSTATION, Platform.PC, Platform.XBOX), 18.0, Genre.HORROR),
                new Videogioco("Street Fighter 6", 2023, 59.99, List.of(Platform.PLAYSTATION, Platform.PC), 25.0, Genre.BRAWLER),
                new GiocoDaTavolo("Indovina Chi", 1995, 319, 2, 20),
                new GiocoDaTavolo("Risiko", 1957, 35, 6, 180),
                new GiocoDaTavolo("Ticket to Ride", 2004, 45, 5, 60),
                new GiocoDaTavolo("Monopoli", 1980, 30, 4, 200),
                new GiocoDaTavolo("Pandemic", 2008, 42, 4, 60)));

//        Collezioni:

        Collezione collezione1 = new Collezione();

//        Interazione utente:

        while (true) {
            System.out.println("""
                    
                    Lista giochi:\s
                    """);
            allTheGames.forEach(gioco -> System.out.println(gioco.getTitle() + " - ID: " + gioco.getId() + " - Prezzo: " + gioco.getPrice() + "€" + " - " + gioco.getClass().getSimpleName()));
            System.out.println("\nInserisci il numero corrispondente e premi invio (inserisci 0 per uscire)");
            System.out.println("\n1. Aggiungi gioco alla tua Collezione.");
            System.out.println("\n2. Cerca nella tua Collezione per ID.");
            System.out.println("\n3. Filtra per prezzo massimo.");
            System.out.println("\n4. Filtra per numero di giocatori.");
            System.out.println("\n5. Rimuovi un gioco dalla Collezione.");
            System.out.println("\n6. Rimpiazza un gioco con un altro.");
            System.out.println("\n7. Stampa i dettagli della Collezione.");
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
                            try {
                                System.out.println("Lista dei giochi che costano meno di " + maxPrice + "€.\n" + collezione1.searchByPrice(maxPrice));
                            } catch (GameNotFound e) {
                                System.out.println(e.getMessage());
                            }

                        }

                    }
                    break;
                }

                case 4: {
                    while (true) {
                        int numOfPlayers = -1;
                        System.out.println("\nInserisci il numero di giocatori (0 per uscire)");
                        try {
                            numOfPlayers = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Formato errato, inserisci un numero");
                            continue;
                        }
                        if (numOfPlayers == 0) break;
                        else {
                            try {
                                System.out.println("Lista dei giochi nei quali si gioca in " + numOfPlayers + " persone:\n" + collezione1.searchByPlayers(numOfPlayers));
                            } catch (GameNotFound e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    }
                    break;
                }

                case 5: {
                    while (true) {
                        long idToRemove = -1;
                        System.out.println("\nInserisci l'ID del gioco da rimuovere, poi premi invio. (0 per uscire)");
                        try {
                            idToRemove = Long.parseLong(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Formato errato, inserisci un ID valido");
                            continue;
                        }
                        if (idToRemove == 0) break;
                        else {
                            long finalIdToRemove = idToRemove;
                            Optional<Gioco> optGameToRemove = collezione1.getGames().stream().filter(gioco -> gioco.getId() == finalIdToRemove).findFirst();
                            if (optGameToRemove.isEmpty()) {
                                System.out.println("ID non trovato.");
                            } else {
                                collezione1.removeGame(finalIdToRemove);
                                System.out.println(optGameToRemove.get().getTitle() + " rimosso dalla Collezione.");
                            }
                        }

                    }

                    break;
                }
                case 6: {
                    while (true) {
                        long idToRemove = -1;
                        System.out.println("\nInserisci l'ID del gioco da sostituire, poi premi invio. (0 per uscire)");
                        try {
                            idToRemove = Long.parseLong(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Formato errato, inserisci un ID valido");
                            continue;
                        }
                        if (idToRemove == 0) break;
                        else {
                            long finalIdToRemove = idToRemove;
                            Optional<Gioco> optGameToRemove = collezione1.getGames().stream().filter(gioco -> gioco.getId() == finalIdToRemove).findFirst();
                            if (optGameToRemove.isEmpty()) {
                                System.out.println("ID non trovato.");
                            } else {
                                long idToSet = -1;
                                while (true) {
                                    System.out.println("Inserisci l'ID del gioco con il quale deve essere rimpiazzato, poi premi invio (0 per uscire)");
                                    try {
                                        idToSet = Long.parseLong(scanner.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Formato errato, inserisci un ID valido");
                                        continue;
                                    }
                                    if (idToSet == 0) break;
                                    long finalIdToSet = idToSet;
                                    Optional<Gioco> optGameToSet = allTheGames.stream().filter(gioco -> gioco.getId() == finalIdToSet).findFirst();
                                    if (optGameToSet.isEmpty()) {
                                        System.out.println("Gioco da inserire non trovato.");
                                    } else {
                                        collezione1.updateGame(idToRemove, optGameToSet.get());
                                        break;
                                    }
                                }
                            }
                        }

                    }
                    break;
                }

                case 7: {
                    collezione1.printCollectionStats();
                    break;
                }


                default:
                    System.out.println("Input non valido");
            }
        }

    }
}
