package pl.kwolszczak.selenium8_1.basic;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.recursive.comparison.ComparingFields;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.kwolszczak.selenium8_1.models.Basket;
import pl.kwolszczak.selenium8_1.pages.products.ProductPage;

import java.util.Comparator;

public class ShopTest {

    @Test
    void addToCartProduct_e2e_test() {
        WebDriver driver = new ChromeDriver();
        Basket expectedBasket = new Basket();

        ProductPage productPage = new ProductPage(driver)
                .addToBasket(expectedBasket)
                .addToBasket(expectedBasket);
                ;
        Assertions.assertThat(expectedBasket).usingRecursiveComparison().isEqualTo(new Basket());


    }
}
