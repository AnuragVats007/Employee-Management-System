package Login;

import java.util.*;

public class login_page {
    Map<String, String> emp = new HashMap<String, String>();

    Scanner ob = new Scanner(System.in);

    public boolean _login() {
        emp.put("Vaidic", "Maheshwari");
        emp.put("Anurag", "Vats");
        emp.put("Aayush", "Verma");
        emp.put("Ashleysha", "Sohala");
        emp.put("Tanya", "Bharti");

        int choice;
        String emp_name, emp_pass;
        boolean flag = true;

        System.out.println("\t \t ----------------------------------------\n ");
        System.out.println(" \t **   WELCOME TO EMPLOYEE MANAGEMENT SYSTEM SOFTWARE LOGIN SCREEN   **\n");
        System.out.println("\t \t ----------------------------------------  \n");
        System.out.println("1. LOGIN");
        System.out.println("2. EXIT");
        choice = ob.nextInt();
        switch (choice) {
        case 1:
            System.out.printf("Enter your username:>> ");
            emp_name = ob.next();
            System.out.printf("Enter your password:>> ");
            emp_pass = ob.next();
            for (Map.Entry<String, String> m : emp.entrySet()) {
                if (m.getKey().equals(emp_name) && m.getValue().equals(emp_pass)) {
                    flag = false;
                    System.out.println("Successfully Logged In as " + emp_name + ".");
                    break;
                }
            }
            if (flag) {
                System.out.println("Invalid username or password");
                System.out.println("TRY AGAIN...");
            }
            break;
        case 2:
            System.out.println("THANKS FOR VISITING...");
            System.exit(0);
            break;
        default:
            System.out.println(">>> Invalid menu choice! Try again.");
            break;
        }
        return flag;
    }
}
