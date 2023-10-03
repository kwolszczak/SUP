package pl.kwolszczak.java1_2;

import java.util.Random;
public class Main {
    public static void main(String[] args) {
        System.out.println(tokenGenerator(3));
        System.out.println(tokenGenerator(18));
        System.out.println(tokenGenerator(15));
    }

    public static String tokenGenerator(int tokenSize) {
        char tokenChar;
        String token = "";

        return switch (tokenSize) {
            case 5, 10, 15 -> {
                for (int i = 0; i < tokenSize; i++) {
                    Random random = new Random();
                    int asciiPosition = random.nextInt(33, 127);

                    tokenChar = (char) asciiPosition;
                    token += tokenChar;
                }
                yield token;
            }
            default -> "Incorrect token Size parameter!";
        };
    }
}
