package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(Locale.forLanguageTag("en"));

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getUserEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String getTelephoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getUserBirthDay() {
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    public String getUserBirthMonth() {
        return faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public String getUserBirthYear() {
        return String.format("%s", faker.number().numberBetween(1924, 2024));
    }

    public String getSubject() {
        return faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry", "Biology",
                "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History",
                "Civics");
    }

    public String getHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getPicture() {
        return faker.options().option("Screen.png", "Picture Screen.png");
    }

    public String getUserAddress() {
        return faker.address().fullAddress();
    }

    public String getUserState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "null";
        };
    }
}