package pl.kwolszczak.java3_2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class Anonymization {
    private static String[] sensitiveData = {"login", "password", "url"};
    private static Map<String, String> anonymizadedMap;

    public static Map<String, String> anonymization(Map<String, String> map) {
        //  anonymizeMap = Map.copyOf(map); // this is not working, because Map.copyOF() produce immutable map
        anonymizadedMap = new HashMap<>(map);

        Consumer<Map.Entry<String, String>> sensitiveSetter = entry -> {
            for (var sensitiveValue : sensitiveData) {
                if (sensitiveValue.equals(entry.getKey())) {
                    entry.setValue("******");
                }
            }
        };
        anonymizadedMap.entrySet().stream().peek(sensitiveSetter).forEach(System.out::println);

        return anonymizadedMap;
    }

    public static void printMap(Map<String, String> map) {
        System.out.println("\n----- MAP -----");
        map.entrySet().stream().forEach(System.out::println);
    }

}

