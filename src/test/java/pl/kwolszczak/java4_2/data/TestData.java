package pl.kwolszczak.java4_2.data;

import java.util.stream.Stream;

public class TestData {

    public static Stream<String> dataProvider() {
        String data="Onet – Jesteś na bieżąco";
        return Stream.of(data);
    }
}
