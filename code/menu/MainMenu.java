package menu;

import InputHandling.SystemInput;
import management.EmployeeManager;

public class MainMenu {

    private final SystemInput systemInput;

    private final EmployeeManager employeeManager;

    private final ManagementMenu managementMenu;

    private final StatisticsMenu statisticsMenu;

    protected static final String INVALID_MENU_CHOICE = ">>> Invalid menu choice! Try again.";

    public MainMenu() {
        employeeManager = new EmployeeManager();
        systemInput = new SystemInput();
        managementMenu = new ManagementMenu(employeeManager, systemInput);
        statisticsMenu = new StatisticsMenu(employeeManager, systemInput);
    }

    public boolean showMainMenu() {
        System.out.println("================ MAIN MENU =================");
        System.out.println(1 + ". Employee management (add, update, delete)");
        System.out.println(2 + ". Employee statistics");
        System.out.println(3 + ". Exit");
        System.out.println("--------------------------------------------");
        System.out.print("> ");

        final int option = systemInput.getInt();
        switch (option) {
        case 1:
            while (managementMenu.showManagementMenu()) {
            }
            break;
        case 2:
            while (statisticsMenu.showStatisticsMenu()) {
            }
            break;
        case 3:
            return false;
        default:
            System.out.println(INVALID_MENU_CHOICE);
            break;
        }
        return true;
    }

    public EmployeeManager getEmployeeManager() {
        return employeeManager;
    }

}
