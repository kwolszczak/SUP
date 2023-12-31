package pl.kwolszczak.selenium7_1.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DataUtil {

    public static Properties getProperties(String path) throws IOException {

        var properties = new Properties();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try (InputStream resourceAsStream = classLoader.getResourceAsStream(path)) {
            if (resourceAsStream == null) {
                throw new FileNotFoundException(" File not found: " + path);
            }

            try (var reader = new BufferedReader(new InputStreamReader(resourceAsStream))) {
                properties.load(reader);
                return properties;
            }
        }
    }

    public static Map<String, String> readCSVToMap(String name) throws IOException {

        Map<String, String> csvData = new HashMap<>();
        Path workingDir = Paths.get("").toAbsolutePath();
        String filePath = workingDir + "/src/test/resources/" + name;

        try (FileReader fileReader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT)) {

            for (CSVRecord csvRecord : csvParser) {
                String key = csvRecord.get(0);
                String value = csvRecord.get(1);
                csvData.put(key, value);
            }
        }

        return csvData;
    }

    public static int countFilesInFolder(String folderPath) {
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            int fileCount = 0;

            for (File file : files) {
                if (file.isFile()) {
                    fileCount++;
                }
            }
            return fileCount;
        } else {
            System.out.println("The specified folder does not exist or is not a directory.");
            return 0;
        }
    }

    public static boolean checkIfFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

}
