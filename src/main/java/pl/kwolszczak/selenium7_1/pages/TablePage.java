package pl.kwolszczak.selenium7_1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.kwolszczak.selenium7_1.components.TableRowComponent;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TablePage {

    private WebDriver driver;
    private List<TableRowComponent> tableRows;

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> table;


    public TablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        setAllRows();
    }

    private void setAllRows() {
        tableRows = new LinkedList<>();
        tableRows = table.stream().map(TableRowComponent::new).toList();
    }

    public TablePage filterRowsByPeaks(String peak) {
        tableRows = tableRows.stream().filter(component -> component.getPeak().equals(peak)).toList();
        return this;
    }

    public TablePage filterRowsByMountainRange(String mountainRange) {
        tableRows = tableRows.stream().filter(component -> component.getMountainRange().equals(mountainRange)).toList();
        return this;
    }

    //OR relation, example setComponentsByState("Italy", "France") will select component with "Italy" or "France" record
    public TablePage filterRowsByState(String... states) {
        tableRows = tableRows.stream()
                .filter(component -> {
                    for (var s : states)
                        if (Arrays.asList(component.getStates()).contains(s)) {
                            return true;
                        }
                    return false;})
                .toList();
        return this;
    }


    public TablePage filterRowsByHeightGreaterThan(int height) {
        tableRows = tableRows.stream().filter(component -> component.getHeight() > height).toList();
        return this;
    }

    public List<TableRowComponent> getRows() {
        return tableRows;
    }
}
