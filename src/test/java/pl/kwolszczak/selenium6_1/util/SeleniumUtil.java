package pl.kwolszczak.selenium6_1.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SeleniumUtil {

    private static Random random = new Random();
    private static Logger log = LoggerFactory.getLogger(SeleniumUtil.class);

    public static void fill(WebElement webElement, String text){
        webElement.clear();
        webElement.sendKeys(text);
    }

    public static void click(WebElement webElement){
        webElement.click();
    }

    public static void selectByValues(WebElement webElement, String... values) {
        Select select = new Select(webElement);
        for (var value : values) {
            select.selectByValue(value);
        }
    }

    public static void selectRandom(WebElement webElement, int numberOfElements) {
        Select select = new Select(webElement);
        int index = random.nextInt(1, numberOfElements+1);
        select.selectByIndex(index);
    }

    public static void clickRandom(List<WebElement> webElements, int numberOfElements){
        int value= random.nextInt(0,numberOfElements);
        webElements.get(value).click();
    }

    public static String switchToSecondWindow(WebDriver driver){

        String originalWindow = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();
     /*   Iterator<String> iterator = windowHandles.iterator();
        String secondWindowHandle = iterator.next();
        driver.switchTo().window(secondWindowHandle);*/

        for (String windowHandle : windowHandles) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return originalWindow;
    }

    public static boolean scrollAndCheckVisibility(WebDriver driver,int pixels) {

        Actions actions = new Actions(driver);
        boolean isVisible = false;
        while (!isVisible) {
            actions.scrollByAmount(0, pixels).build().perform();
            try {
                WebElement button = driver.findElement(By.cssSelector("input#scroll-button"));
                isVisible = button.isDisplayed();
                log.info("Founded searched button {}",button.getText());
                return true;
            } catch (Exception e) {
                log.debug("Not Founded yet button");
            }
        }
        return false;
    }

    public static boolean scrollAndCheckVisibilityJSExecutor(WebDriver driver,int pixels) {

        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        boolean isVisible = false;
        while (!isVisible) {
            jsExec.executeScript("window.scrollBy(0,"+pixels+")");
            try {
                WebElement button = driver.findElement(By.cssSelector("input#scroll-button"));
                isVisible = button.isDisplayed();
                log.info("Founded searched button {}",button.getText());
                return true;
            } catch (Exception e) {
                log.debug("Not Founded yet button");
            }
        }
        return false;
    }

    public static void takeScreenShoot(WebDriver driver) throws IOException {

        String fileName = "screenshot.png";
        log.info("Take a screenshot {}",fileName);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "target/"+fileName;
        FileUtils.copyFile(screenshot, new File(path));
    }
}
