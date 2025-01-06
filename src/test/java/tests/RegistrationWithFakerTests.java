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
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.gender)
                .setNumber(testData.telephoneNumber)
                .setDateOfBirth(testData.userBirthDay, testData.userBirthMonth, testData.userBirthYear)
                .setSubjects(testData.subject)
                .setHobbies(testData.hobbies)
                .uploadFromClasspath(testData.picture)
                .setCurrentAddress(testData.userAddress)
                .setState(testData.userState)
                .setCity(testData.userCity)
                .submitButton();

        registrationPage.verifyResult("Student Name",testData.firstName + " " + testData.lastName)
                .verifyResult("Student Email", testData.userEmail)
                .verifyResult("Gender", testData.gender)
                .verifyResult("Mobile", testData.telephoneNumber)
                .verifyResult("Date of Birth", testData.userBirthDay + " " + testData.userBirthMonth +","+ testData.userBirthYear)
                .verifyResult("Subjects", testData.subject)
                .verifyResult("Hobbies", testData.hobbies)
                .verifyResult("Picture", testData.picture)
                .verifyResult("Address", testData.userAddress)
                .verifyResult("State and City", testData.userState + " " + testData.userCity);
    }
}

