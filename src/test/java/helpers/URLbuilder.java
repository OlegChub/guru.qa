package helpers;

public class URLbuilder {
    public static String urlBuilder(String login, String password, String url) {
        return "https://" + login + ":" + password + "@" + url;
    }
}
