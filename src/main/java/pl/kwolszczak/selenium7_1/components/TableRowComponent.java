package pl.kwolszczak.selenium7_1.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.Arrays;

public class TableRowComponent {

    @FindBy(xpath = "./th")
    private WebElement rank;

    @FindBy(xpath = "./td[1]")
    private WebElement peak;

    @FindBy(xpath = "./td[2]")
    private WebElement mountainRange;

    @FindBy(xpath = "./td[3]")
    private WebElement state;

    @FindBy(xpath = "./td[4]")
    private WebElement height;


    public TableRowComponent(WebElement parent) {
        PageFactory.initElements(new DefaultElementLocatorFactory(parent), this);
    }

    public int getRank() {
        return Integer.parseInt(rank.getText());
    }

    public String getPeak() {
        return peak.getText();
    }
    public String getMountainRange() {
        return mountainRange.getText();
    }

    public String[] getStates() {
        return state.getText().replaceAll("\\s+","").split(",");
    }

    public int getHeight() {
        return Integer.parseInt(height.getText());
    }

    @Override
    public String toString() {
        return "TableRowComponent{" +
                "rank=" + rank.getText() +
                ", peak=" + peak.getText() +
                ", mountainRange=" + mountainRange.getText() +
                ", state=" + Arrays.toString(state.getText().replaceAll("\\s+","").split(",")) +
                ", height=" + height.getText() +
                '}';
    }
}
