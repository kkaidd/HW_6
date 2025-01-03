package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithMinimalDataTests extends TestBase{
    private RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationWithMinimalDataTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Johny")
                .setLastName("Bond")
                .setGender("Other")
                .setNumber("9520931995")
                .submitButton();

        registrationPage.verifyResult("Student Name", "Johny Bond")
                .verifyResult("Gender", "Other")
                .verifyResult("Mobile", "9520931995");
    }
}
