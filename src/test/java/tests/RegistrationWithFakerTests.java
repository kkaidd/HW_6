package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;


public class RegistrationWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    String firstName = testData.getFirstName();
    String lastName = testData.getLastName();
    String userEmail = testData.getUserEmail();
    String gender = testData.getGender();
    String telephoneNumber = testData.getTelephoneNumber();
    String userBirthDay = testData.getUserBirthDay();
    String userBirthMonth = testData.getUserBirthMonth();
    String userBirthYear = testData.getUserBirthYear();
    String subject = testData.getSubject();
    String hobbies = testData.getHobbies();
    String picture = testData.getPicture();
    String userAddress = testData.getUserAddress();
    String userState = testData.getUserState();
    String userCity = testData.getRandomCity(userState);

    @Test
    void successfulSearchTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setNumber(telephoneNumber)
                .setDateOfBirth(userBirthDay, userBirthMonth, userBirthYear)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .uploadFromClasspath(picture)
                .setCurrentAddress(userAddress)
                .setState(userState)
                .setCity(testData.getRandomCity(userState))
                .submitButton();

        registrationPage
                .verifyResult("Student Name",firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", telephoneNumber)
                .verifyResult("Date of Birth", userBirthDay + " " + userBirthMonth +","+ userBirthYear)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", picture)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);
    }
}

