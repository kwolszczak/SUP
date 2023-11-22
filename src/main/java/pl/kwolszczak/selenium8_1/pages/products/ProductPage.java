package pl.kwolszczak.selenium8_1.pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.kwolszczak.selenium8_1.models.Basket;
import pl.kwolszczak.selenium8_1.models.Product;

public class ProductPage {

    private WebDriver driver;

    @FindBy(css = "")
    private WebElement nameLable;

    @FindBy(css = "")
    private WebElement quantityInp;

    @FindBy(css = "")
    private WebElement price;

    @FindBy(css = "")
    private WebElement addToBasketBtn;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ProductPage addToBasket(Basket basket) {
        addToBasketBtn.click();
        basket.addProduct(new Product(nameLable.getText(),getPrice()), Integer.parseInt(quantityInp.getText()));
        return this;
    }

    public double getPrice() {
        return Double.parseDouble(price.getText());
    }
}
