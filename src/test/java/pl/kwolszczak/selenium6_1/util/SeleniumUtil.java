package pl.kwolszczak.selenium6_1.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class SeleniumUtil {

    private static Random random = new Random();

    public static void fill(WebElement webElement, String text){
        webElement.clear();
        webElement.sendKeys(text);
    }

    public static void click(WebElement webElement){
        webElement.click();
    }

    public static void selectMulti(WebElement webElement, String... values) {
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
}
