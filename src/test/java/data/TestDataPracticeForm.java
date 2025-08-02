package data;

import com.github.javafaker.Faker;
import tests.TestBase;

import java.util.Locale;
public class TestDataPracticeForm extends TestBase {
    static Faker faker = new Faker(new Locale("en-GB"));

    // Генерация данных
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String fullName = firstName + " " + lastName;
    public static String email = faker.internet().emailAddress();
    public static String gender = faker.options().option("Female", "Male", "Other");
    public static String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public static String dayOfBirth = String.format("%02d",faker.number().numberBetween(1, 28));
    public static String monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    public static String yearOfBirth = String.format("%s", faker.number().numberBetween(1900, 2007));
    public static String subject = faker.options().option("Maths", "Physics", "Chemistry", "Biology", "English", "History", "Geography", "Computer Science", "Economics", "Arts", "Hindi", "Social Studies");
    public static String hobby = faker.options().option("Sports", "Reading", "Music");
    public static String picture = faker.options().option("photo.jpg", "photo1.jpg", "photo2.jpg");
    public static String address = faker.address().fullAddress();
    public static String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public static String city = selectCity(state);
    public static String stateAndCity = state + " " + city;

    public static String selectCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };


    }
}