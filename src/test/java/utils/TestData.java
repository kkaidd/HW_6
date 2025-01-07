package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(Locale.forLanguageTag("en"));

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getGender() {
        return gender;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getUserBirthDay() {
        return userBirthDay;
    }

    public String getUserBirthMonth() {
        return userBirthMonth;
    }

    public String getUserBirthYear() {
        return userBirthYear;
    }

    public String getSubject() {
        return subject;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getPicture() {
        return picture;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserState() {
        return userState;
    }

    public String getUserCity() {
        return userCity;
    }

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String telephoneNumber = faker.phoneNumber().subscriberNumber(10);
    public String userBirthDay = String.format("%02d", faker.number().numberBetween(1, 28));
    public String userBirthMonth = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December");
    public String userBirthYear = String.format("%s", faker.number().numberBetween(1924, 2024));
    public String subject = faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry", "Biology",
                    "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History",
                    "Civics");
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String picture = faker.options().option("Screen.png", "Picture Screen.png");
    public String userAddress = faker.address().fullAddress();
    public String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String userCity = getRandomCity(userState);

    public String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}