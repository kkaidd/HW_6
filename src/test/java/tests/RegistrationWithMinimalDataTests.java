package tests;
import pages.RegistrationPage;

import org.junit.jupiter.api.Test;
import utils.TestData;

public class RegistrationWithMinimalDataTests extends TestBase{
    private RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void successfulRegistrationWithMinimalDataTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setGender(testData.getGender())
                .setNumber(testData.getTelephoneNumber())
                .submitButton();

        registrationPage.verifyResult("Student Name",testData.getFirstName() + " " + testData.getLastName())
                .verifyResult("Gender", testData.getGender())
                .verifyResult("Mobile", testData.getTelephoneNumber());
    }
}
