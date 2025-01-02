package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class NegativeValuesRegistrationTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void invalidFirstNameRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("")
                .setLastName("Bond")
                .setGender("Other")
                .setNumber("9520931995")
                .submitButton();
    }

    @Test
    void invalidLastNameRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Johny")
                .setLastName("")
                .setGender("Other")
                .setNumber("9520931995")
                .submitButton();
    }

    @Test
    void invalidPhoneNumberRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Johny")
                .setLastName("Bond")
                .setGender("Other")
                .setNumber("123")
                .submitButton();
    }
}
