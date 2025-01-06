package tests;

import utils.TestData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class NegativeValuesRegistrationTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
    void invalidFirstNameRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("")
                .setLastName("Bond")
                .setGender("Other")
                .setNumber("9520931995")
                .submitButton()
                .checkFirstNameError();
    }

    @Test
    void invalidLastNameRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Johny")
                .setLastName("")
                .setGender("Other")
                .setNumber("9520931995")
                .submitButton()
                .checkLastNameError();
    }

    @Test
    void invalidPhoneNumberRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setNumber(" ")
                .submitButton()
                .checkMobileNumberError();
    }

    @Test
    void invalidGenderRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setNumber(testData.telephoneNumber)
                .submitButton()
                .checkGenderErrorExists("rgb(220, 53, 69)");
    }
}
