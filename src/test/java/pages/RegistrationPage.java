package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private   SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            userSubjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setNumber(String value){
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
    return this;

    }
    public RegistrationPage verifyResult(String key, String value){
        resultsTableComponent.checkResultTable(key, value);
        return this;
    }

    public RegistrationPage setSubjects(String value){
        userSubjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value){
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadFromClasspath(String value){
        uploadPicture.uploadFromClasspath("Screen.png");
        return this;
    }
    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value){
        stateInput.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value){
        cityInput.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage submitButton(){
        submitButton.click();
        return this;
    }
    public RegistrationPage checkFirstNameError() {
        firstNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public RegistrationPage checkLastNameError() {
        lastNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public RegistrationPage checkGenderErrorExists(String value) {
        $$(".custom-radio label")
                .filterBy(cssValue("border-color", value))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }


    public RegistrationPage checkMobileNumberError() {
        userNumber.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }
}