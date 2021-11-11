import Login.*;
import menu.MainMenu;

public class Main {
    public static void main(String[] args) {
        login_page lp = new login_page();
        while (lp._login()) {
        }

        MainMenu mainMenu = new MainMenu();
        while (mainMenu.showMainMenu()) {
        }
    }
}