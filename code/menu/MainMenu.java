package menu;

import InputHandling.*;
import management.EmployeeManager;

public class MainMenu {

    private final SystemInput systemInput;

    private final EmployeeManager employeeManager;

    private final ManagementMenu managementMenu;

    private final StatisticsMenu statisticsMenu;

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
            System.out.println("THANKS FOR VISITING...");
            return false;
        default:
            System.out.println(">>> Invalid menu choice! Try again.");
            break;
        }
        return true;
    }

    public EmployeeManager getEmployeeManager() {
        return employeeManager;
    }
}
