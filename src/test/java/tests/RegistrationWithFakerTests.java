package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;


public class RegistrationWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
    void successfulSearchTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setUserEmail(testData.getUserEmail())
                .setGender(testData.getGender())
                .setNumber(testData.getTelephoneNumber())
                .setDateOfBirth(testData.getUserBirthDay(), testData.getUserBirthMonth(), testData.getUserBirthYear())
                .setSubjects(testData.getSubject())
                .setHobbies(testData.getHobbies())
                .uploadFromClasspath(testData.getPicture())
                .setCurrentAddress(testData.getUserAddress())
                .setState(testData.getUserState())
                .setCity(testData.getUserCity())
                .submitButton();

        registrationPage.verifyResult("Student Name",testData.getFirstName() + " " + testData.getLastName())
                .verifyResult("Student Email", testData.getUserEmail())
                .verifyResult("Gender", testData.getGender())
                .verifyResult("Mobile", testData.getTelephoneNumber())
                .verifyResult("Date of Birth", testData.getUserBirthDay() + " " + testData.getUserBirthMonth() +","+ testData.getUserBirthYear())
                .verifyResult("Subjects", testData.getSubject())
                .verifyResult("Hobbies", testData.getHobbies())
                .verifyResult("Picture", testData.getPicture())
                .verifyResult("Address", testData.getUserAddress())
                .verifyResult("State and City", testData.getUserState() + " " + testData.getUserCity());
    }
}

