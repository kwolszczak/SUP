package pl.kwolszczak.java4_1;

import java.io.IOException;
import java.util.Scanner;

import static pl.kwolszczak.java4_1.util.FileUtils.getJsonData;

public class MoviesLibraryDisplay {

    private static Scanner scanner = new Scanner(System.in);
    private static MoviesLibrary library  ;

    private MoviesLibraryDisplay() {
    }

    private static void displayMenu() {
        String menu = """
            
            
            1. Podaj dwie daty aby wyświetlić nazwy filmów wydanych pomiędzy tymi datami                    
            2. Wyświetl wszystkie informacje o losowym filmie                  
            3. Podaj imię i nazwisko aktora aby wyświetlić nazwy filmów w jakich zagrał
            4. Zamknij""";

        System.out.println(menu);
    }

    private static void searchByDates() {

        System.out.print("Write date from, example: 1997: ");
        int dateFrom = Integer.parseInt(scanner.nextLine());

        System.out.print("Write date to, example: 2017: ");
        int dateTo = Integer.parseInt(scanner.nextLine());

        library.findMoviesByDates(dateFrom, dateTo);
    }

    private static void searchByActor() {

        System.out.print("Write first Name, example: Tom: ");
         String firstName = scanner.nextLine();

        System.out.print("Write last Name, example: Ford: ");
        String lastName = scanner.nextLine();

        library.findMovieByActor(firstName, lastName);
    }

    private static void findRandomMovie() {
        library.findRandomMovie();
    }



    public static void run() throws IOException {

        boolean quit = false;
        int option;
        library = getJsonData("myMovies");

        do {
            displayMenu();
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> searchByDates();
                case 2 -> findRandomMovie();
                case 3 -> searchByActor();
                case 4 -> quit = true;
                default -> System.out.println("Wrong option");
            }
        } while (!quit);
    }
}
