package homework.lesson7;

public enum MenuItems {
    ALL_ITEMS("All Items"),
    ABOUT("About"),
    LOGOUT("Logout"),
    RESET_APP_STATE("Reset App State");

    private final String value;

    MenuItems(String value) {
        this.value = value;
    }

    public String getName() {
        return value;
    }
}
