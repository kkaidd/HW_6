package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en"));

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
    public String picture = faker.options().option("Screen.png", "Screen duplication.png");
    public String userAddress = faker.address().fullAddress();
    public String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String userCity = getRandomCity(userState);

    public String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");

            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");

            case "Haryana":
                return faker.options().option("Karnal", "Panipat");

            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");

            default:
                return null;
        }

    }


}