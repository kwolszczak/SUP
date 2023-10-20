package pl.kwolszczak.java3_2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Anonymization {
    private static String[] defaultSensitiveData = {"login", "password", "pin", "birthDate", "PESEL"};


    public static Map<String, String> anonymization(Map<String, String> map) {
        return anonymization(map, defaultSensitiveData);
    }

    public static Map<String, String> anonymization(Map<String, String> map, String[] sensitiveData) {

        boolean needAnonymization = false;

        for (var sensitiveValue : sensitiveData) {
            if (map.containsKey(sensitiveValue)) {
                needAnonymization = true;
                break;
            }
        }

        if (!needAnonymization) {
            System.out.println("\n----- Anonymization -----");
            System.out.println("No sensitive data in your map");
            return map;
        }

        //  anonymizeMap = Map.copyOf(map); // this is not working, because Map.copyOF() produce immutable map
        Map<String, String> anonymizadedMap = new HashMap<>(map);
        Consumer<Map.Entry<String, String>> sensitiveSetter = entry -> {
            for (var sensitiveValue : sensitiveData) {
                if (sensitiveValue.equals(entry.getKey())) {
                    entry.setValue("******");
                }
            }
        };
        System.out.println("\n----- Anonymization -----");
        anonymizadedMap.entrySet().stream().peek(sensitiveSetter).forEach(System.out::println);

        return anonymizadedMap;
    }


    public static void printMap(Map<String, String> map) {
        System.out.println("\n-----  YOUR MAP -----");
        map.entrySet().stream().forEach(System.out::println);
    }

}

