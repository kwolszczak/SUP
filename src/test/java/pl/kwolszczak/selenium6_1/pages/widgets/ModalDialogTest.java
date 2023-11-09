package pl.kwolszczak.selenium6_1.pages.widgets;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pl.kwolszczak.selenium6_1.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.kwolszczak.selenium6_1.util.SeleniumUtil.*;

record User(String name, String email, String password) {
}

class ModalDialogTest extends BaseTest {

    private String url = "http://www.seleniumui.moderntester.pl/modal-dialog.php";

    //@Test
    @RepeatedTest(10)
    @DisplayName("Menu")
    void menuTest_simpleTest() throws InterruptedException {

        driver.get(url);
        var createUser = driver.findElement(By.id("create-user"));
        var user = new User("Tom", "Ford@grantorino.it", "admin123");

        click(createUser);
        switchToSecondWindow(driver);

        var name = driver.findElement(By.id("name"));
        var email = driver.findElement(By.id("email"));
        var password = driver.findElement(By.id("password"));
        var create = driver.findElement(By.xpath("//button[contains(text(),'Create an account')]"));

        fill(name, user.name());
        fill(email, user.email());
        fill(password, user.password());
        click(create);

        var allUsers = driver.findElements(By.xpath("//tbody //tr"))
                .stream()
                .map(we -> new User(
                        we.findElement(By.xpath("./td[1]")).getText(),
                        we.findElement(By.xpath("./td[2]")).getText(),
                        we.findElement(By.xpath("./td[3]")).getText()))
                .toList();

        assertThat(allUsers).contains(user);
    }


}
