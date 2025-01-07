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
                .setFirstName(" ")
                .setLastName(testData.getLastName())
                .setGender(testData.getGender())
                .setNumber(testData.getTelephoneNumber())
                .submitButton()
                .checkFirstNameError();
    }

    @Test
    void invalidLastNameRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.getFirstName())
                .setLastName(" ")
                .setGender(testData.getGender())
                .setNumber(testData.getTelephoneNumber())
                .submitButton()
                .checkLastNameError();
    }

    @Test
    void invalidPhoneNumberRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setGender(testData.getGender())
                .setNumber(" ")
                .submitButton()
                .checkMobileNumberError();
    }

    @Test
    void invalidGenderRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setNumber(testData.getTelephoneNumber())
                .submitButton()
                .checkGenderErrorExists("rgb(220, 53, 69)");
    }
}
