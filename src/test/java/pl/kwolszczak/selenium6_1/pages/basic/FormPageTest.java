package pl.kwolszczak.selenium6_1.pages.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static pl.kwolszczak.selenium6_1.util.DataUtil.*;
import static pl.kwolszczak.selenium6_1.util.SeleniumUtil.*;

class FormPageTest extends BaseTest {
    private final String url = "http://www.seleniumui.moderntester.pl/form.php";

    @Test
    //@RepeatedTest(10)
    @DisplayName("Form test")
    void formPageTest_basicTest() {

        String expectedResult = "Form send with success";
        driver.get(url);

        var firstName = driver.findElement(By.cssSelector("input#inputFirstName3"));
        var lastName = driver.findElement(By.cssSelector("input#inputLastName3"));
        var email = driver.findElement(By.cssSelector("input#inputEmail3"));
        var age = driver.findElement(By.cssSelector("input#inputAge3"));
        var professionAT = driver.findElement(By.cssSelector("input#gridCheckAutomationTester"));
        var seleniumCMDSelect = driver.findElement(By.cssSelector("#selectSeleniumCommands"));
        var continentsSelect = driver.findElement(By.cssSelector("#selectContinents"));
        var choseFile = driver.findElement(By.cssSelector("input#chooseFile"));
        var submit = driver.findElement(By.cssSelector("button[type=submit]"));
        var validatorMSG = driver.findElement(By.cssSelector("#validator-message"));
        var radioSexBtn = driver.findElements(By.cssSelector("input[name='gridRadiosSex']"));
        var yearsOfExperience = driver.findElements(By.cssSelector("input[name='gridRadiosExperience']"));

        var file = new File("src\\main\\resources\\file.txt");
        var filePath = file.getAbsolutePath();

        fill(firstName, "hello");
        fill(lastName, "Kitty");
        fill(email, "hell66.yeas@hk.com");
        fill(age, "12");
        clickRandom(radioSexBtn, 3);
        clickRandom(yearsOfExperience, 7);
        click(professionAT);
        selectRandom(continentsSelect, 7);
        selectByValues(seleniumCMDSelect, "switch-commands", "wait-commands");
        fill(choseFile, filePath);
        click(submit);

        var result = validatorMSG.getText();
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    //@RepeatedTest(10)
    @DisplayName("Number of files test")
    void formPageTest_countFiles() {

        driver.get(url);
        var path = "src\\main\\resources\\";
        var fileName = "test-file-to-download.xlsx";
        final int initialNumOfFiles = countFilesInFolder(path);
        var downloadFileBtn = driver.findElement(By.cssSelector("a[role='button']"));

        click(downloadFileBtn);
        await().atMost(10, TimeUnit.SECONDS)
                .until(() -> countFilesInFolder(path) > initialNumOfFiles);


        var currentNumOfFiles = countFilesInFolder(path);
        var isFileExist = checkIfFileExists(path + fileName);

        assertThat(currentNumOfFiles).isGreaterThan(initialNumOfFiles);
        assertThat(isFileExist).isTrue();
    }
}
