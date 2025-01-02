package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase{
RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulSearchTest() {
        registrationPage.openPage()
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




//
//        $("[class~=table]").shouldHave(text("Student Name")).shouldHave(text("Kaid Sulimanov"));
//        $("[class~=table]").shouldHave(text("Student Email")).shouldHave(text("kkaidd@mail.ru"));
//       gradle build --warning-mode all $("[class~=table]").shouldHave(text("Gender")).shouldHave(text("Other"));
//        $("[class~=table]").shouldHave(text("Mobile")).shouldHave(text("9520931995"));
//        $("[class~=table]").shouldHave(text("Date of Birth")).shouldHave(text("10 November,1990"));
//        $("[class~=table]").shouldHave(text("Subjects")).shouldHave(text("English, Hindi"));
//        $("[class~=table]").shouldHave(text("Hobbies")).shouldHave(text("Sports"));
//        $("[class~=table]").shouldHave(text("Picture")).shouldHave(text("Screen.png"));
//        $("[class~=table]").shouldHave(text("Address")).shouldHave(text("Город Москва, улица скворцова-спепанова, дом 15"));
//        $("[class~=table]").shouldHave(text("State and City")).shouldHave(text("NCR Delhi"));
//

    }
}
