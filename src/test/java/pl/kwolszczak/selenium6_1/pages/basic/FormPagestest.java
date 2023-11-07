package pl.kwolszczak.selenium6_1.pages.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class FormPagestest extends BaseTest {

    @Test
    //@RepeatedTest(10)
    @DisplayName("form test")
    void FormPages_basicTest() throws InterruptedException {
        driver.get("http://www.seleniumui.moderntester.pl/form.php");
        WebElement firstName = driver.findElement(By.cssSelector("input#inputFirstName3"));
        firstName.sendKeys("jan");

        WebElement lastName = driver.findElement(By.cssSelector("input#inputLastName3"));
        lastName.sendKeys("kowalski");

        WebElement email = driver.findElement(By.cssSelector("input#inputEmail3"));
        email.sendKeys("jan.kowalski@jk.com");
        WebElement age = driver.findElement(By.cssSelector("input#inputAge3"));
        age.sendKeys("12");

        List<WebElement> radioSexBtn = driver.findElements(By.cssSelector("input[name='gridRadiosSex']"));
        Random random = new Random();
        int rb = random.nextInt(0, 3);
        radioSexBtn.get(rb).click();

        int rds = random.nextInt(1, 8);
        WebElement yearOfExperience = driver.findElement(By.cssSelector("input#gridRadios" + rds));
        yearOfExperience.click();

        Select select = new Select(driver.findElement(By.cssSelector("#selectContinents")));
        int rcou = random.nextInt(1, 8);
        select.selectByIndex(rcou);

        Select select1 = new Select(driver.findElement(By.cssSelector("#selectSeleniumCommands")));
        select1.selectByValue("switch-commands");
        select1.selectByValue("wait-commands");
        driver.findElement(By.cssSelector("input#gridCheckAutomationTester")).click();
        var fileInput = driver.findElement(By.cssSelector("input#chooseFile"));


        // Set the file path to the file input element
        String filePath = "C:\\Users\\kwolszczak_adm\\IdeaProjects\\SUP\\log\\mojPlikBezNazwy.log"; // Replace with the actual file path
       /* File f = new File("\\src    \\main\\resources\\file.txt");
        fPath = f.getAbsolutePath();*/
        fileInput.sendKeys(filePath);

        driver.findElement(By.cssSelector("button[type=submit]")).click();

        String result = driver.findElement(By.cssSelector("#validator-message")).getText();
        Assertions.assertThat(result).isEqualTo("Form send with success");

        driver.quit();


    }

    @Test
    void test_countFiles() throws InterruptedException {
        String path = "C:\\Users\\kwolszczak_adm\\IdeaProjects\\SUP\\logi";
        File f = new File(path + "\\test-file-to-download.xlsx");

        int files = countFilesInFolder(path);
        System.out.println(files);

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", path);
        options.setExperimentalOption("prefs", prefs);


        WebDriver driver1;
        driver1 = new ChromeDriver(options);
        driver1.get("http://www.seleniumui.moderntester.pl/form.php");
        driver1.findElement(By.cssSelector("a[role='button']")).click();
   /*     await().atMost(10, TimeUnit.SECONDS)

                .until(()->f.exists());*/
        int finalFiles = files;
        await().atMost(10, TimeUnit.SECONDS)

                .until(() -> countFilesInFolder(path) > finalFiles);

        files = countFilesInFolder(path);
        System.out.println(files);

        System.out.println(checkIfFileExists(path + "\\test-file-to-download.xlsx"));

    }

    private static int countFilesInFolder(String folderPath) {
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            int fileCount = 0;

            for (File file : files) {
                if (file.isFile()) {
                    fileCount++;
                }
            }

            return fileCount;
        } else {
            System.out.println("The specified folder does not exist or is not a directory.");
            return 0;
        }
    }

    private static boolean checkIfFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}
