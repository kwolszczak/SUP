package pl.kwolszczak.selenium7_1.pages;

import org.junit.jupiter.api.Test;
import pl.kwolszczak.selenium7_1.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

class TablePageTest extends BaseTest {

    private String url = "http://www.seleniumui.moderntester.pl/table.php";

    @Test
    void tablePage_findData() {

        int expectedResult = 5;
        driver.get(url);

        var tp = new TablePage(driver)
                .setComponentsByState("Italy", "France")
                .setComponentsByHeightGreaterThan(4000);

        var result = tp.getComponentsData();
        result.forEach(System.out::println);

        assertThat(result.size()).isEqualTo(expectedResult);
    }

}