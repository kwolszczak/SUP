package pl.kwolszczak.selenium7_1.pages;

import org.junit.jupiter.api.Test;
import pl.kwolszczak.selenium7_1.BaseTest;
import pl.kwolszczak.selenium7_1.util.Profession;

import static org.assertj.core.api.Assertions.assertThat;

class FormPageTest extends BaseTest {

    private String url = "http://www.seleniumui.moderntester.pl/form.php";

    @Test
    void formPage_signIn_withRandoData() {

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
        assertThat(result).isEqualTo(expectedResult);
    }

}