package pl.kwolszczak.selenium7_1.pages;

import org.junit.jupiter.api.Test;
import pl.kwolszczak.selenium7_1.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

class TablePageTest extends BaseTest {

    private String url = "http://www.seleniumui.moderntester.pl/table.php";

    @Test
    void tablePage_findRows_whenStatesEqualItalyOrFrance_andWhenHeightGreaterThan4000m() {

        int searchedRowsSize = 5;
        driver.get(url);

        var tablePage = new TablePage(driver)
                .filterRowsByState("Italy", "France")
                .filterRowsByHeightGreaterThan(4000);

        var actualRows = tablePage.getRows();
        actualRows.forEach(System.out::println);

        assertThat(actualRows.size()).isEqualTo(searchedRowsSize);
    }

}