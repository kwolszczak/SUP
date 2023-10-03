package pl.kwolszczak.java1_1;

import java.util.Random;
import static pl.kwolszczak.java1_1.GuessGame.playGame;

public class Main {
    public static void main(String[] args) {
        int numberToGuess = new Random().nextInt(100);
        playGame(numberToGuess);
    }


}

