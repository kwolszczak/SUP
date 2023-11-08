package pl.kwolszczak.selenium6_1.pages.interactions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium6_1.BaseTest;


public class Draggable extends BaseTest {

    private String url = "http://www.seleniumui.moderntester.pl/draggable.php";
    private Logger log = LoggerFactory.getLogger(Draggable.class);

    @Test
    //@RepeatedTest(10)
    @DisplayName("Draggable Test")
    void draggablePage_simpleTest()  {

        driver.get(url);

        var element = driver.findElement(By.id("draggable"));
        var actions = new Actions(driver);

        final var X_WIN = driver.manage().window().getSize().getWidth() - 16; // nieprawidlowa wartosc 3456 a powinno byc max 3440
        final var Y_WIN = driver.manage().window().getSize().getHeight() - 186; //?? konfiguracja 2x monitory 3440x1440
        final var X_ELEM = element.getSize().width;
        final var Y_ELEM = element.getSize().height;
        final var X_CENT = X_WIN / 2;
        final var Y_CENT = Y_WIN / 2;

        var xPosition = element.getLocation().getX();
        var yPosition = element.getLocation().getY();
        log.info("Browser actual size after correction: x:{} y:{}", X_WIN, Y_WIN);

        //0->1 : up right corner
        actions.dragAndDropBy(element, X_WIN - xPosition - X_ELEM, -yPosition)
                .build()
                .perform();

        //1->2 :bot rig
        actions.dragAndDropBy(element, 0, Y_WIN - Y_ELEM)
                .build()
                .perform();

        //2->3 :to center
        var xPositionCen = element.getLocation().getX() - X_CENT;
        var yPositionCen = element.getLocation().getY() - Y_CENT;
        actions.dragAndDropBy(element, -xPositionCen, -yPositionCen)
                .build()
                .perform();

        //3->4 :to left bot
        actions.dragAndDropBy(element, -X_CENT, Y_CENT - Y_ELEM)
                .build()
                .perform();

    }

}
