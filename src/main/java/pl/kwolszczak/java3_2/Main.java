package pl.kwolszczak.java3_2;

import pl.kwolszczak.java3_2.FileUtil.DataUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        var properties = DataUtil.getProperties("anonymous");
        Anonymization.addSensitiveData("url");

        var map = Anonymization.mask(properties);
        Anonymization.printMap(map);
    }
}
