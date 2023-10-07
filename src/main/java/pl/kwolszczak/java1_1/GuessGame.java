package pl.kwolszczak.java1_1;

import java.util.Scanner;

public class GuessGame {
    public static void playGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int leftAttempts = 5;
        boolean isGuessed;
        int yourNumber;

        System.out.println("Guess the number from 0 to 99");
        do {
            System.out.println("-".repeat(40));
            System.out.println("Write your answer and press ENTER");

            yourNumber = scanner.nextInt();
            isGuessed = checkAnswer(yourNumber, numberToGuess);
            leftAttempts--;

            if (isGuessed){
                break;
            }
            printAttemptsInfo(leftAttempts);
        } while (leftAttempts > 0);

        if (!isGuessed) {
            System.out.println("Sorry you didn't guess the number, the answer was: " + numberToGuess);
        }
    }

    private static boolean checkAnswer(int yourNumber, int numberToGuess) {

        if (yourNumber > numberToGuess) {
            System.out.println("Your number is GREATER than the one you are trying to guess");
        } else if (yourNumber < numberToGuess) {
            System.out.println("Your number is LOWER than the one you are trying to guess");
        } else {
            System.out.println("You guessed it!");
            return true;
        }
        return false;
    }

    private static void printAttemptsInfo(int leftAttempts) {
        if (leftAttempts > 0) {
            System.out.println("\tPlease try again");
            System.out.printf("\tYou have %d attempts left%n", leftAttempts);
        }
    }
}
