package TestData;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    private static Faker faker = new Faker(new Locale("ru"));

    private static String firstName = faker.name().firstName();
    private static String lastName = faker.name().lastName();
    private static String userEmail = faker.bothify("????##@????.??");
    private static String gender;
    private static String userNumber = faker.regexify("[0-9]{10}");
    private static String[] birthday = {"11", "March", "1900"};
    private static String[] subjects = {"Computer Science", "English", "Maths", "History", "Hindi", "Arts"};
    private static String subject;
    private static String[] hobbies = {"Sports", "Reading", "Music"};
    private static String[] genders = {"Male", "Female", "Other"};
    private static String hobby;
    private static String state = "Rajasthan";
    private static String city = "Jaipur";
    private static String address = faker.address().fullAddress();
    public static final String PIC_NAME = "chucknorris.jpg";

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getUserEmail() {
        return userEmail;
    }

    public static String getUserNumber() {
        return userNumber;
    }

    public static String[] getBirthDayDate() {
        return birthday;
    }

    public static String setSubject() {
        int min = 0;
        int max = subjects.length;
        int random_num = min + (int) (Math.random() * max);
        return subject = subjects[random_num];
    }

    public static String getSubject() {
        return subject;
    }

    public static String setHobby() {
        int min = 0;
        int max = hobbies.length;
        int random_num = min + (int) (Math.random() * max);
        return hobby = hobbies[random_num];
    }

    public static String getHobby() {
        return hobby;
    }

    public static String setGender() {
        int min = 0;
        int max = genders.length;
        int random_num = min + (int) (Math.random() * max);
        return gender = genders[random_num];
    }

    public static String getGender() {
        return gender;
    }

    public static String getState() {
        return state;
    }

    public static String getCity() {
        return city;
    }

    public static String getCurrentAddress() {
        return address;
    }

}
