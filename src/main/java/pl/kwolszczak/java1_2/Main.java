package pl.kwolszczak.java1_2;

import java.util.Random;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println(tokenGenerator(3));
        System.out.println(tokenGenerator(18));
        System.out.println(tokenGenerator(15));
    }

    public static String tokenGenerator(int tokenSize) {
        StringBuilder token = new StringBuilder(15);
        int asciiPosition;
        char tokenChar;

        return switch (tokenSize) {
            case 5, 10, 15 -> {
                for (int i = 0; i < tokenSize; i++) {
                    asciiPosition = random.nextInt(33, 127);
                    tokenChar = (char) asciiPosition;
                    token.append(tokenChar);
                }
                yield token.toString();
            }
            default -> "Incorrect token Size parameter!";
        };
    }
}
