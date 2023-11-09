package pl.kwolszczak.selenium6_1.pages.interactions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SortableTest extends BaseTest {

    private Logger log = LoggerFactory.getLogger(SortableTest.class);

    //@Test
    @RepeatedTest(10)
    @DisplayName("Sortable")
    void sortablePageTest_simpleTest() {

            log.info("Start test: {}", testInfo.getDisplayName());
        var url = "http://automation-practice.emilos.pl/sortable.php";
        driver.get(url);
        var actions = new Actions(driver);
        var listInt = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        var lastBtn = driver.findElement(By.xpath("//*[@id='sortable']/li[contains(text(),'Item 7')]"));
        var end = lastBtn.getLocation().getY();
            log.debug("List of integers: {}", listInt);
        Collections.shuffle(listInt);
            log.debug("List of integers after shuffle: {}", listInt);;
        var expectedResult = new ArrayList<>(listInt);
            log.debug("expected result: {}", expectedResult);

        listInt.stream()
                .map(i -> driver.findElement(By.xpath("//*[@id='sortable']/li[contains(text(),'Item " + i + "')]")))
                .forEach(button -> {
                    int yOffSet = end - button.getLocation().y + 5;
                    actions.dragAndDropBy(button, 0, yOffSet).build().perform();
                });

        var result = driver.findElements(By.xpath("//*[@id='sortable']/li"))
                .stream()
                .map(e -> Integer.parseInt(e.getText().replaceAll("Item ", "")))
                .toList();
        log.debug("List of result: {}", result);

        assertThat(result).isEqualTo(expectedResult);
    }
}
