package pl.kwolszczak.selenium6_1.pages.widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pl.kwolszczak.selenium6_1.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

class TooltipTest extends BaseTest {

    private String url = "http://www.seleniumui.moderntester.pl/tooltip.php";

    @Test
    //@RepeatedTest(10)
    @DisplayName("Tooltip")
    void tooltipPageTest_simpleTest() {

        driver.get(url);
        var expectedResult = "We ask for your age only for statistical purposes.";
        var tooltipBtn = driver.findElement(By.cssSelector("input#age"));
        var result = tooltipBtn.getAttribute("title");

        assertThat(result).isEqualTo(expectedResult);
    }
}
