package pl.kwolszczak.selenium6_1.pages.others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.io.IOException;

import static pl.kwolszczak.selenium6_1.util.SeleniumUtil.*;

public class HighSitePageTest extends BaseTest {
    String url = "http://automation-practice.emilos.pl/high-site.php";

    @Test
    //@RepeatedTest(10)
    @DisplayName("High Test Scroll")
    void highPageTest_scroll_whenUseScrollOption() throws IOException {

        driver.get(url);
        boolean result = scrollAndCheckVisibility(driver,800);
        takeScreenShoot(driver);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    //@RepeatedTest(10)
    @DisplayName("High Test JSExecutor")
    void highPageTest_scroll_whenUseJSExecutor() throws IOException {

        driver.get(url);
        boolean result = scrollAndCheckVisibilityJSExecutor(driver, 100);
        takeScreenShoot(driver);

        Assertions.assertThat(result).isTrue();
    }
}
