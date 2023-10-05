package pl.kwolszczak.java1_2;

import static pl.kwolszczak.java1_2.Token.tokenGenerator;

public class Main {
    public static void main(String[] args) {
        System.out.println(tokenGenerator(3));
        System.out.println(tokenGenerator(18));
        System.out.println(tokenGenerator(15));
    }
}
