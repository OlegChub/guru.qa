import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    private Faker faker = new Faker(new Locale("ru"));

    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String userEmail = faker.bothify("????##@????.??");
    private String gender = "Other";
    private String userNumber = faker.regexify("[0-9]{10}");
    private String[] birthday = {"11", "March", "1900"};
    private String[] subjects = {"Computer Science", "English", "Maths", "History", "Hindi", "Arts"};
    private String subject;
    private String[] hobbies = {"Sports", "Reading", "Music"};
    private String hobby;
    private String state = "Rajasthan";
    private String city = "Jaipur";
    private String address = faker.address().fullAddress();
    public static final String PIC_NAME = "chucknorris.jpg";

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

    public String userNumber() {
        return userNumber;
    }

    public String[] getBirthDayDate() {
        return birthday;
    }

    public String setSubject() {
        int min = 0;
        int max = subjects.length;
        int random_num = min + (int) (Math.random() * max);
        return subject=subjects[random_num];
    }
    public String getSubject() {
        return subject;
    }

    public String setHobby() {
        int min = 0;
        int max = hobbies.length;
        int random_num = min + (int) (Math.random() * max);
        return hobby=hobbies[random_num];
    }
    public String getHobby() {
        return hobby;
    }
    public String getState() {
        return state;
    }
    public String getCity() {
        return city;
    }
    public String getCurrentAddress() {
        return address;
    }

}
