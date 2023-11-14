package pl.kwolszczak.selenium7_2.pages;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kwolszczak.selenium7_2.BaseTest;
import pl.kwolszczak.selenium7_2.util.Profession;

import static org.junit.jupiter.api.Assertions.*;

class FormPageTest extends BaseTest {

    private String url = "http://www.seleniumui.moderntester.pl/form.php";

    @Test
    void simpleTest(){

        String expectedResult = "Form send with success";

        driver.get(url);
        FormPage fp = new FormPage(driver)
                .fillName("Tom", "Bob")
                .fillAge(18)
                .fillEmail("tom@koku.pl")
                .selectProfession(Profession.AUTOMATION)
                .chooseRandomSex()
                .chooseRandomYearsOfExperience()
                .chooseRandomContinent()
                .selectCommands("switch-commands", "wait-commands")
                .chooseFile("file")
                .signIn();

        var result = fp.getSignInInfo();
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

}