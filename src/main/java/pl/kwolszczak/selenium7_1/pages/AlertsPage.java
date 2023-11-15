package pl.kwolszczak.selenium7_1.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

    private WebDriver driver;

    @FindBy(css = "#simple-alert")
    private WebElement simpleAlertBtn;
    @FindBy(css = "#simple-alert-label")
    private WebElement simpleAlertInfo;

    @FindBy(css = "#prompt-alert")
    private WebElement promptAlertBtn;
    @FindBy(css = "#prompt-label")
    private WebElement promptAlertInfo;

    @FindBy(css = "#confirm-alert")
    private WebElement confirmBtn;
    @FindBy(css = "#confirm-label")
    private WebElement confirmInfo;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AlertsPage acceptSimpleAlert() {

        simpleAlertBtn.click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
        return this;
    }

    public AlertsPage fillPromptAlertByName(String name)  {

        promptAlertBtn.click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys(name);
        promptAlert.accept();
        return this;
    }

    public AlertsPage confirmAlertBox(){
        confirmBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public AlertsPage cancelAlertBox() {
        confirmBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        return this;
    }

    public String getSimpleAlertInfo() {
        return simpleAlertInfo.getText();
    }

    public String getPromptAlertInfo() {
        return promptAlertInfo.getText();
    }

    public String getConfirmAlertBoxInfo() {
        return confirmInfo.getText();
    }
}
