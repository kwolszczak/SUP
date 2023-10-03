package pl.kwolszczak.java1_1;

import java.util.Scanner;

public class GuessGame {
    public static void playGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        boolean guessed = false;
        int maxAttempts = 5;
        int yourNumber;

        System.out.println("Guess the number from 0 to 99");
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.println("-".repeat(40));
            System.out.println("Write your answer and press ENTER");

            yourNumber = scanner.nextInt();
            guessed = checkAnswer(yourNumber, numberToGuess);

            if (guessed) break;
            else {
                printAttemptsInfo(attempt, maxAttempts);
            }
        }

        if (!guessed) {
            System.out.println("Sorry you didn't guess the number, the answer was: " + numberToGuess);
        }
    }

    private static boolean checkAnswer(int yourNumber, int numberToGuess) {
        boolean guessed = false;

        if (yourNumber > numberToGuess) {
            System.out.println("Your number is GREATER than the one you are trying to guess");
        } else if (yourNumber < numberToGuess) {
            System.out.println("Your number is LOWER than the one you are trying to guess");
        } else {
            System.out.println("You guessed it!");
            guessed = true;
        }
        return guessed;
    }

    private static void printAttemptsInfo(int attempt, int maxAttempts) {
        int leftAttempts = maxAttempts - attempt;
        if (attempt < maxAttempts) {
            System.out.println("\tPlease try again");
            System.out.println("\tYou have " + leftAttempts + " attempts left");
        }
    }
}
