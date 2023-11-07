package pl.kwolszczak.selenium6_1.pages.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static pl.kwolszczak.selenium6_1.util.DataUtil.*;
import static pl.kwolszczak.selenium6_1.util.SeleniumUtil.*;

public class FormPagestest extends BaseTest {

    private String url = "http://www.seleniumui.moderntester.pl/form.php";

    @Test
    //@RepeatedTest(10)
    @DisplayName("Form test")
    void FormPages_basicTest() {

        String expectedResult = "Form send with success";

        driver.get(url);
        WebElement firstName = driver.findElement(By.cssSelector("input#inputFirstName3"));
        WebElement lastName = driver.findElement(By.cssSelector("input#inputLastName3"));
        WebElement email = driver.findElement(By.cssSelector("input#inputEmail3"));
        WebElement age = driver.findElement(By.cssSelector("input#inputAge3"));
        WebElement professionAT = driver.findElement(By.cssSelector("input#gridCheckAutomationTester"));
        WebElement seleniumCMDSelect = driver.findElement(By.cssSelector("#selectSeleniumCommands"));
        WebElement continentsSelect = driver.findElement(By.cssSelector("#selectContinents"));
        WebElement choseFile = driver.findElement(By.cssSelector("input#chooseFile"));
        WebElement submit = driver.findElement(By.cssSelector("button[type=submit]"));
        WebElement validatorMSG = driver.findElement(By.cssSelector("#validator-message"));
        List<WebElement> radioSexBtn = driver.findElements(By.cssSelector("input[name='gridRadiosSex']"));
        List<WebElement> yearsOfExperience = driver.findElements(By.cssSelector("input[name='gridRadiosExperience']"));

        File file = new File("src\\main\\resources\\file.txt");
        String filePath = file.getAbsolutePath();

        fill(firstName, "hello");
        fill(lastName, "Kitty");
        fill(email, "hell66.yeas@hk.com");
        fill(age, "12");
        clickRandom(radioSexBtn, 3);
        clickRandom(yearsOfExperience, 7);
        click(professionAT);
        selectRandom(continentsSelect, 7);
        selectMulti(seleniumCMDSelect, "switch-commands", "wait-commands");
        fill(choseFile, filePath);
        click(submit);

        String result = validatorMSG.getText();
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    //@RepeatedTest(10)
    @DisplayName("Number of files test")
    void test_countFiles() throws InterruptedException {

        String path = "src\\main\\resources\\";
        String fileName = "test-file-to-download.xlsx";
        File file = new File(path);
        final int initialNumOfFiles = countFilesInFolder(path);

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", file.getAbsolutePath());
        options.setExperimentalOption("prefs", prefs);

        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.get("http://www.seleniumui.moderntester.pl/form.php");

        chromeDriver.findElement(By.cssSelector("a[role='button']")).click();
        await().atMost(10, TimeUnit.SECONDS)
                .until(() -> countFilesInFolder(path) > initialNumOfFiles);
        chromeDriver.quit();


        int currentNumOfFiles = countFilesInFolder(path);
        boolean isFileExist = checkIfFileExists(path + fileName);
        assertThat(currentNumOfFiles).isGreaterThan(initialNumOfFiles);
        assertThat(isFileExist).isTrue();
    }


}
