package pl.kwolszczak.selenium6_1.pages.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static pl.kwolszczak.selenium6_1.util.DataUtil.checkIfFileExists;
import static pl.kwolszczak.selenium6_1.util.DataUtil.countFilesInFolder;
import static pl.kwolszczak.selenium6_1.util.SeleniumUtil.*;

class FormPagesTest extends BaseTest {
    private final String url = "http://www.seleniumui.moderntester.pl/form.php";

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
    void test_countFiles() {
        driver.get(url);

        String path = "src\\main\\resources\\";
        String fileName = "test-file-to-download.xlsx";
        final int initialNumOfFiles = countFilesInFolder(path);
        WebElement downloadFileBtn = driver.findElement(By.cssSelector("a[role='button']"));

        click(downloadFileBtn);
        await().atMost(10, TimeUnit.SECONDS)
                .until(() -> countFilesInFolder(path) > initialNumOfFiles);


        int currentNumOfFiles = countFilesInFolder(path);
        boolean isFileExist = checkIfFileExists(path + fileName);

        assertThat(currentNumOfFiles).isGreaterThan(initialNumOfFiles);
        assertThat(isFileExist).isTrue();
    }


}
