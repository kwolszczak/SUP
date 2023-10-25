package pl.kwolszczak.java3_2;

import java.util.*;
import java.util.function.Consumer;

public class Anonymization {
    private static List<String> sensitiveData = new ArrayList<>(Arrays.asList("login", "password"));
    private static String mask = "******";

    public static void addSensitiveData(String sensitive) {
        if (!sensitiveData.contains(sensitive)) {
            sensitiveData.add(sensitive);
            System.out.println("log: '" + sensitive + "' added to sensitive Data list");
        }else{
            System.out.println("log: '" + sensitive + "' is already on the sensitive Data list");
        }
    }

    public static Map<String, String> mask(Map<String, String> map) {

        Map<String, String> anonymizadedMap = new HashMap<>(map);
        Consumer<Map.Entry<String, String>> sensitiveSetter = entry -> {
            for (var sensitiveValue : sensitiveData) {
                if (sensitiveValue.equals(entry.getKey())) {
                    entry.setValue(mask);
                }
            }
        };

        var count = anonymizadedMap.entrySet().stream()
                .peek(sensitiveSetter)
                .filter(e -> e.getValue().equals(mask))
                .count();
        System.out.printf("log: %s fields has been anonymized %n", count);

        return anonymizadedMap;
    }

    public static void printMap(Map<String, String> map) {
        System.out.println("\n-----  YOUR MAP -----");
        map.entrySet().stream().forEach(System.out::println);
    }
}

