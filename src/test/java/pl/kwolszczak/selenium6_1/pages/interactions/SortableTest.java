package pl.kwolszczak.selenium6_1.pages.interactions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SortableTest extends BaseTest {

    @Test
    //@RepeatedTest(10)
    @DisplayName("Sortable")
    void sortablePageTest_simpleTest() {

        var url = "http://automation-practice.emilos.pl/sortable.php";
        driver.get(url);
        var actions = new Actions(driver);
        var listInt = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        var item7 = driver.findElement(By.xpath("//*[@id='sortable']/li[contains(text(),'Item 7')]"));
        var end = item7.getLocation().getY();

        Collections.shuffle(listInt);
        listInt.stream()
                .map(i -> driver.findElement(By.xpath("//*[@id='sortable']/li[contains(text(),'Item " + i + "')]")))
                .forEach((s) -> actions.dragAndDropBy(s, 0, end - s.getLocation().y + 5)
                        .build()
                        .perform());
        var result = driver.findElements(By.xpath("//*[@id='sortable']/li"))
                .stream()
                .map(e -> e.getText().replaceAll("Item ", ""))
                .map(Integer::parseInt)
                .toList();

        assertThat(result).isEqualTo(listInt);
    }
}
