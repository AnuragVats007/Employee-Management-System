package menu;

import InputHandling.SystemInput;
import management.EmployeeManager;
import management.EmployeeRecords;

class StatisticsMenu {

    private final SystemInput systemInput;

    private final EmployeeRecords employeeStatistics;

    protected StatisticsMenu(EmployeeManager employeeManager, SystemInput systemInput) {
        this.systemInput = systemInput;
        this.employeeStatistics = new EmployeeRecords(employeeManager);
    }

    protected boolean showStatisticsMenu() {
        System.out.println("=========== EMPLOYEE STATISTICS ============");
        System.out.println(1 + ". Average salary at the company");
        System.out.println(2 + ". Maximum salary in the company");
        System.out.println(3 + ". Minimum salary in the company");
        System.out.println(4 + ". Total bonus");
        System.out.println(5 + ". Women in percentage in the company");
        System.out.println(6 + ". Men percentage of the various work role categories");
        System.out.println(0 + ". Back to Main Menu");
        System.out.println("--------------------------------------------");
        System.out.print("> ");

        final int option = systemInput.getInt();
        switch (option) {
        case 0:
            return false;
        case 1:
            employeeStatistics.displayAverageSalary();
            break;
        case 2:
            employeeStatistics.displayMaxSalary();
            break;
        case 3:
            employeeStatistics.displayMinSalary();
            break;
        case 4:
            employeeStatistics.displayTotalBonus();
            break;
        case 5:
            employeeStatistics.displayWomenStaffPercentage();
            break;
        case 6:
            employeeStatistics.displayMenPercentageOfWorkRole();
            break;
        default:
            System.out.println(">>> Invalid menu choice! Try again.");
            break;
        }

        System.out.println("Press Enter to continue...");
        systemInput.getString();

        return true;
    }

}
