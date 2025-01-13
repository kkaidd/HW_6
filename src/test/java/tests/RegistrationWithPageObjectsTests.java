package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;


public class RegistrationWithPageObjectsTests extends TestBase{
RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulSearchTest() {
        registrationPage.openPage()
        .removeBanner()
        .setFirstName("Johny")
        .setLastName("Bond")
        .setUserEmail("kkaidd@mail.ru")
        .setGender("Other")
        .setNumber("9520931995")
        .setDateOfBirth("13", "July", "2001")
        .setSubjects("English")
        .setHobbies("Sports")
        .uploadFromClasspath("Screen.png")
        .setCurrentAddress("Город Москва, улица скворцова-спепанова, дом 15")
        .setState("NCR")
        .setCity("Delhi")
        .submitButton();

        registrationPage.verifyResult("Student Name", "Johny Bond")
        .verifyResult("Student Email", "kkaidd@mail.ru")
        .verifyResult("Gender", "Other")
        .verifyResult("Mobile", "9520931995")
        .verifyResult("Date of Birth", "13 July,2001")
        .verifyResult("Subjects", "English")
        .verifyResult("Hobbies", "Sports")
        .verifyResult("Picture", "Screen.png")
        .verifyResult("Address", "Город Москва, улица скворцова-спепанова, дом 15")
        .verifyResult("State and City", "NCR Delhi");
    }
}
