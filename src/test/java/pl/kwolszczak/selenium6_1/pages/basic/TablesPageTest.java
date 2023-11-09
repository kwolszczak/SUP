package pl.kwolszczak.selenium6_1.pages.basic;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pl.kwolszczak.selenium6_1.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.kwolszczak.selenium6_1.util.TableUtil.getTableData;
import static pl.kwolszczak.selenium6_1.util.TableUtil.printData;


class TablesPageTest extends BaseTest {

    //@Test
    @RepeatedTest(10)
    @DisplayName("Tables Page")
    void tablesPageTest_simpleTest() {

        String url = "http://www.seleniumui.moderntester.pl/table.php";
        driver.get(url);

        var rows = driver.findElements(By.cssSelector("table tbody tr"));
        var data = getTableData(rows, 4000, "Switzerland");
        printData(data);

        assertThat(data).hasSize(6) ;
    }
}
