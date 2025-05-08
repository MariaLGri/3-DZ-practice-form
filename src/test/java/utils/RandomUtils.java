
package utils;
import com.github.javafaker.Faker;
import java.util.Locale;


public class RandomUtils {
    Faker faker = new Faker(new Locale("en-GB"));
    public String firstNameF = faker.name().firstName();
    public String lastNameF = faker.name().lastName();
    public String userEmailF = faker.internet().emailAddress();
    public String streetAddress = faker.address().streetAddress();
    public String ruPhone = faker.phoneNumber().subscriberNumber(10);
    public String genterWrapper = faker.options().option("Male", "Female", "Other");
    public String BirthInput = String.format("%s", faker.number().numberBetween(9, 11));
    public String monthOfBirthInput = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December");
    public String yearOfBirthInput = String.format("%s", faker.number().numberBetween(1900, 2000));
    public String piktureF = faker.options().option("prt.png",
            "landscape.jpg",
            "avatar.gif");
    public String subjects = faker.options().option("Arts", "Hindi", "English", "History", "Maths", "Physics", "Chemistry", "Biology");
    public String hobbiesInput = faker.options().option("Sports", "Reading", "Music");
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = selectCity(state);
    public String randomLetters = faker.regexify("[A-Za-z]{10}");

    public String selectCity(String state) {
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

//    public static String getRandomString(int len) {
////        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//        SecureRandom rnd = new SecureRandom();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < len; i++)
//            sb.append(AB.charAt(rnd.nextInt(AB.length())));
//
//        return sb.toString();
//    }
}