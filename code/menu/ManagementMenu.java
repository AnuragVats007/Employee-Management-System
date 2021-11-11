package menu;

import InputHandling.SystemInput;
import employee.Gender;
import employee.Profession;
import management.EmployeeManager;

class ManagementMenu {

    private final SystemInput systemInput;
    private final EmployeeManager employeeManager;

    protected ManagementMenu(EmployeeManager employeeManager, SystemInput systemInput) {
        this.employeeManager = employeeManager;
        this.systemInput = systemInput;
    }

    protected boolean showManagementMenu() {
        System.out.println("============ EMPLOYEE MANAGEMENT =============");
        System.out.println(1 + ". Register employee");
        System.out.println(2 + ". Delete employee");
        System.out.println(3 + ". Update name of employee");
        System.out.println(4 + ". Update the age of employee");
        System.out.println(5 + ". Update the profession/department of employee");
        System.out.println(6 + ". Update salary of employee");

        System.out.println(7 + ". Search employee ");

        System.out.println(8 + ". Display all employees");
        System.out.println(0 + ". Back to main menu");
        System.out.println("----------------------------------------------");
        System.out.print("> ");

        final int option = systemInput.getInt();
        switch (option) {
        case 0:
            return false;
        case 1:
            registerEmployee();
            break;
        case 2: {
            deleteEmployee();
            break;
        }
        case 3:
        case 4:
        case 5:
        case 6:
            updateEmployee(option);
            break;
        case 7:
            searchEmployee();
            break;
        case 8:
            employeeManager.displayAll();
            break;
        default:
            System.out.println(">>> Invalid menu choice! Try again.");
            break;
        }

        System.out.println("Press Enter to continue...");
        systemInput.getString();

        return true;
    }

    private void deleteEmployee() {
        System.out.print("ID of employee to delete: ");
        int employeeId = systemInput.getInt();
        if (employeeManager.delete(employeeId)) {
            System.out.println(">>> Employee successfully deleted.");
        } else {
            System.out.println(">>> Error! Employee deletion failed.");
        }
    }

    private Profession getProfession() {
        System.out.print("Profession/department (1=Secretary, 2=Technician, 3=Programmer): ");
        Profession profession;
        switch (systemInput.getInt()) {
        case 1:
            profession = Profession.SECRETARY;
            break;
        case 2:
            profession = Profession.TECHNICIAN;
            break;
        case 3:
            profession = Profession.PROGRAMMER;
            break;
        default:
            profession = Profession.INVALID;
            break;
        }
        return profession;
    }

    private void searchEmployee() {
        System.out.print("Employee ID number: ");
        int employeeId = systemInput.getInt();
        employeeManager.search(employeeId, null, null);
    }

    private void updateEmployee(int option) {
        System.out.print("ID of employee to update: ");
        int employeeId = systemInput.getInt();

        boolean success;
        switch (option) {
        case 3: {
            System.out.print("New first name: ");
            String fname = systemInput.getString().trim();
            System.out.print("New last name: ");
            String lname = systemInput.getString().trim();
            success = employeeManager.update(employeeId, fname + " " + lname, 0, null, null, null);
            break;
        }
        case 4: {
            System.out.print("New (corrected) age (YYYYMMDD): ");
            int age = systemInput.getInt();
            success = employeeManager.update(employeeId, null, age, null, null, null);
            break;
        }
        case 5: {
            Profession profession = getProfession();
            success = employeeManager.update(employeeId, null, 0, profession, null, null);
            break;
        }
        case 6: {
            System.out.print("New salary: ");
            int salary = systemInput.getInt();
            success = employeeManager.update(employeeId, null, 0, null, salary, null);
            break;
        }
        default:
            success = false;
            break;
        }

        if (success) {
            System.out.println(">>> Employee successfully updated.");
        } else {
            System.out.println(">>> Error! Employee update failed. Bad input?");
        }
    }

    private void registerEmployee() {
        System.out.print("First name: ");
        String name = systemInput.getString().trim();
        //System.out.print("Last name: ");
        //String lname = systemInput.getString().trim();
        System.out.print("Age: ");
        int age = systemInput.getInt();
        System.out.print("Salary: ");
        int salary = systemInput.getInt();
        Profession profession = getProfession();
        System.out.print("Gender (1=Man, 2=Woman, 3=Undefined): ");
        int gender = systemInput.getInt();
        Gender genderType = Gender.UNDEFINED;
        if (gender == 1) {
            genderType = Gender.MAN;
        } else if (gender == 2) {
            genderType = Gender.WOMAN;
        }
        if (employeeManager.add(name, age, profession, salary, genderType)) {
            System.out.println(">>> Employee successfully registered!");
        } else {
            System.out.println(">>> Error! Failure to register employee. Bad input?");
        }
    }
}
