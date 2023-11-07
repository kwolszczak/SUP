package pl.kwolszczak.selenium6_1.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Arrays;
import java.util.List;

public class TableUtil {
    public static List<WebElement> getTableData(List<WebElement> rows, int maxHeight, String state) {
        return rows.stream()
                .filter(w -> Integer.parseInt(w.findElement(By.xpath("./td[4]")).getText()) >= maxHeight)
                .filter(w -> Arrays.stream(w.findElement(By.xpath("./td[3]")).getText().split(",")).toList().contains(state))
                .toList();
    }

    public static void printData(List<WebElement> data) {
        data.stream()
                .map(s -> s.getText().split("\\s+"))
                .forEach(s -> System.out.println(s[0] + " " + s[1] + " " + s[2]));
    }
}
