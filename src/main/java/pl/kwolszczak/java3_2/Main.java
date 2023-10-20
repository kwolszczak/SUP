package pl.kwolszczak.java3_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, String> properties = new HashMap();
        properties.put("login", "Angelina");
        properties.put("password", "angelinaInHollywood123");
        properties.put("title", "Salt");
        properties.put("url", "www.angelina.hollywood");
        properties.put("errorMessage", "file has not been founded");

        String[] sensitiveData = {"title", "errorMessage", "url"};

        Map<String, String> anonymizedMap = Anonymization.anonymization(properties,sensitiveData);
        Anonymization.anonymization(properties);
        Anonymization.anonymization(properties, new String[]{"baba"});

        System.out.println("\n\noriginal map");
        Anonymization.printMap(properties);
        System.out.println("\n\nanonymized map");
        Anonymization.printMap(anonymizedMap);
    }
}
