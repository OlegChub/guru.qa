package TestData;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    private static final Faker faker = new Faker(new Locale("ru"));

    public static final String PIC_NAME = "chucknorris.jpg";
    public final static String FIRST_NAME = faker.name().firstName();
    public final static String LAST_NAME = faker.name().lastName();
    public final static String USER_EMAIL = faker.bothify("????##@????.??");
    public final static String USER_NUMBER = faker.regexify("[0-9]{10}");
    public final static String[] BIRTHDAY = {"11", "March", "1900"};
    private final static String[] SUBJECTS = {"Computer Science", "English", "Maths", "History", "Hindi", "Arts"};
    private final static String[] HOBBIES = {"Sports", "Reading", "Music"};
    private final static String[] GENDERS = {"Male", "Female", "Other"};
    public final static String HOBBY = generateRandomTestDataFromArray(HOBBIES);
    public final static String GENDER = generateRandomTestDataFromArray(GENDERS);
    public final static String SUBJECT = generateRandomTestDataFromArray(SUBJECTS);
    public final static String ADDRESS = faker.address().fullAddress();
    public final static String STATE = "Rajasthan";
    public final static String CITY = "Jaipur";

    private static String generateRandomTestDataFromArray(String[] array) {
        int min = 0;
        int max = array.length;
        int random_num = min + (int) (Math.random() * max);
        return array[random_num];
    }

    public static String getBirthdayItem(String item) {
        String data=null;
        switch (item){
            case "day":
                data=BIRTHDAY[0];
                break;
            case "month":
                data=BIRTHDAY[1];
                break;
            case "year":
                data=BIRTHDAY[2];
                break;
            default:
                System.out.println("Check your data");
        }
        return data;
    }

}
