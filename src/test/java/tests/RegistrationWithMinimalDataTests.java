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
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setNumber(testData.telephoneNumber)
                .submitButton();

        registrationPage.verifyResult("Student Name",testData.firstName + " " + testData.lastName)
                .verifyResult("Gender", testData.gender)
                .verifyResult("Mobile", testData.telephoneNumber);
    }
}
