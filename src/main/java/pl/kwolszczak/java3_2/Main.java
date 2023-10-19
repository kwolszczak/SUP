package pl.kwolszczak.java3_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

        Map<String, String> properties = new HashMap();
        properties.put("login", "Angelina");
        properties.put("password", "angelinaInHollywood123");
        properties.put("title", "Salt");
        properties.put("url", "www.angelina.hollywood");
        properties.put("errorMessage", "file has not been founded");

        String[] sensualKeys = {"login", "password", "url"};

        UnaryOperator<Map.Entry<String, String>> sensitiveMapper = entry -> {
            Arrays.stream(sensualKeys).forEach(sensitiveValue -> {
                if (entry.getKey().equals(sensitiveValue)) {
                    entry.setValue("******");
                }
            });
            return entry;
        };


        properties.entrySet().stream()
                .map(sensitiveMapper)
                .forEach(System.out::println);
    }
}
