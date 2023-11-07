package pl.kwolszczak.selenium6_1.pages.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pl.kwolszczak.selenium6_1.BaseTest;

import static pl.kwolszczak.selenium6_1.util.SeleniumUtil.*;
import static pl.kwolszczak.selenium6_1.util.TableUtil.*;

public class WindowsPageTest extends BaseTest {
    private String url = "http://www.seleniumui.moderntester.pl/windows-tabs.php";

    @Test
    //@RepeatedTest(10)
    @DisplayName("Windows Page Test")
    void windowsPageTest_simpleTest() {
        driver.get(url);
        String  mainWindowHandle;
        var newBrowserWindow = driver.findElement(By.cssSelector("#newBrowserWindow"));
        var newMessageWindow = driver.findElement(By.cssSelector("#newMessageWindow"));
        var newBrowserTab = driver.findElement(By.cssSelector("#newBrowserTab"));

        click(newBrowserWindow);
        mainWindowHandle = switchToSecondWindow(driver);
        var rows = driver.findElements(By.cssSelector("table tbody tr"));
        var data = getTableData(rows, 4000, "Switzerland");
        printData(data);
        driver.close();
        driver.switchTo().window(mainWindowHandle);

        click(newMessageWindow);
        switchToSecondWindow(driver);
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        driver.close();
        driver.switchTo().window(mainWindowHandle);

        click(newBrowserTab);
        switchToSecondWindow(driver);
        var rows2 = driver.findElements(By.cssSelector("table tbody tr"));
        var data2 = getTableData(rows2, 4000, "Switzerland");
        printData(data2);
    }
}
