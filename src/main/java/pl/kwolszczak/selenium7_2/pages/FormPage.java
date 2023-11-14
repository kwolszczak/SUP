package pl.kwolszczak.selenium7_2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.kwolszczak.selenium7_2.util.Profession;
import pl.kwolszczak.selenium7_2.util.SeleniumUtil;

import java.io.File;
import java.util.List;

import static pl.kwolszczak.selenium7_2.util.SeleniumUtil.*;

public class FormPage {

    private WebDriver driver;


    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameInp;

    @FindBy(css = "#inputLastName3")
    private WebElement lastNameInp;

    @FindBy(css = "#inputEmail3")
    private WebElement emailInp;

    @FindBy(css = "#inputAge3")
    private WebElement ageInp;

    @FindBy(css = "input#gridCheckAutomationTester")
    private WebElement professionAT;

    @FindBy(css = "input#gridCheckManulTester")
    private WebElement professionMT;

    @FindBy(css = "input#gridCheckOther")
    private WebElement professionOth;

    @FindBy(css = "#selectSeleniumCommands")
    private WebElement seleniumCMDSelect;

    @FindBy(css = "#selectContinents")
    private WebElement continentsSelect;

    @FindBy(css = "input#chooseFile")
    private WebElement chooseFileBtn;

    @FindBy(css = "button[type=submit]")
    private WebElement submit;

    @FindBy(css = "#validator-message")
    private WebElement validatorMSG;

    @FindBy(css = "input[name='gridRadiosSex']")
    private List<WebElement> radioSexBtn;

    @FindBy(css = "input[name='gridRadiosExperience']")
    private List<WebElement> yearsOfExperience;


    public FormPage(WebDriver driver) {
        this.driver = driver;
        SeleniumUtil.init(driver);
        PageFactory.initElements(driver, this);
    }

    public FormPage fillName(String firstName, String lastName) {
        fill(firstNameInp, firstName);
        fill(lastNameInp, lastName);
        return this;
    }

    public FormPage fillAge(int age) {
        fill(ageInp, String.valueOf(age));
        return this;
    }

    public FormPage fillEmail(String email) {
        fill(emailInp, email);
        return this;
    }

    public FormPage chooseRandomSex() {
        clickRandom(radioSexBtn, 3);
        return this;
    }

    public FormPage chooseRandomYearsOfExperience() {
        clickRandom(yearsOfExperience, 7);
        return this;
    }

    public FormPage chooseRandomContinent() {
        selectRandom(continentsSelect, 7);
        return this;
    }

    public FormPage selectCommands(String... args) {
        selectByValues(seleniumCMDSelect, args);
        return this;

    }

    public FormPage selectProfession(Profession profession) {

        switch (profession) {
            case MANUAL -> click(professionMT);
            case AUTOMATION -> click(professionAT);
            default -> click(professionOth);
        }
        return this;
    }

    public FormPage chooseFile(String fileName) {
        File file = new File("src\\main\\resources\\" + fileName + ".txt");
        String filePath = file.getAbsolutePath();
        fill(chooseFileBtn, filePath);
        return this;
    }

    public FormPage signIn() {
        click(submit);
        return this;

    }

    public String getSignInInfo() {
        return validatorMSG.getText();
    }

}
