package pl.kwolszczak.java1_2;

import java.util.Random;

public class Token {
    private static final Random random = new Random();
    private static final String msg = "Incorrect token Size parameter!";
    private static int[] validTokenSize = {5, 10, 15};

    public static String tokenGenerator(int tokenSize) {
        String result;

      /*  //with parametrization
        for (var token : validTokenSize) {
            if (tokenSize == token) {
                result = getString(tokenSize);
            } else {
                result = msg;
            }
        }*/

        result = switch (tokenSize) {
            case 5, 10, 15 -> getString(tokenSize);
            default -> msg;
        };
        return result;
    }

    private static String getString(int tokenSize) {
        StringBuilder token = new StringBuilder(15);
        int asciiPosition;
        char tokenChar;
        for (int i = 0; i < tokenSize; i++) {
            asciiPosition = random.nextInt(33, 127);
            tokenChar = (char) asciiPosition;
            token.append(tokenChar);
        }
        return token.toString();
    }
}
