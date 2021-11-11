package management;

import employee.*;
import java.util.ArrayList;

public class EmployeeManager {
    String proff;

    private final ArrayList<Employee> employees = new ArrayList<>();

    public boolean add(String name, int age, Profession profession, int salary, Gender gender) {
        Employee employee;
        switch (profession) {
        case SECRETARY:
            employee = new Secretary(name, age, salary, gender);
            break;
        case TECHNICIAN:
            employee = new Technician(name, age, salary, gender);
            break;
        case PROGRAMMER:
            employee = new Programmer(name, age, salary, gender);
            break;
        case INVALID:
        default:
            employee = null;
            break;
        }

        if (employee != null) {
            employees.add(employee);
            return true;
        }
        return false;
    }

    private int getIndexOfEmployee(int employeeId) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getEmployeeId() == employeeId) {
                return i;
            }
        }
        return -1;
    }

    public boolean delete(int employeeId) {
        int indexOfEmployee = getIndexOfEmployee(employeeId);
        if (indexOfEmployee != -1) {
            employees.remove(indexOfEmployee);
            return true;
        }
        return false;
    }

    public boolean update(int employeeId, String name, int age, Profession profession, Integer salary, Gender gender) {
        int indexOfEmployee = getIndexOfEmployee(employeeId);
        if (indexOfEmployee != -1) {
            Employee employee = employees.get(indexOfEmployee);
            if (name != null) {
                employee.setName(name);
            }
            if (age != 0) {
                employee.setage(age);
            }
            if (salary != null) {
                employee.setSalary(salary);
            }
            if (gender != null) {
                employee.setGender(gender);
            }
            if (profession != null) {
                switch (profession) {
                case SECRETARY:
                    Secretary secretary = new Secretary(employee);
                    employees.set(indexOfEmployee, secretary);
                    break;
                case TECHNICIAN:
                    Technician technician = new Technician(employee);
                    employees.set(indexOfEmployee, technician);
                    break;
                case PROGRAMMER:
                    Programmer programmer = new Programmer(employee);
                    employees.set(indexOfEmployee, programmer);
                    break;
                case INVALID:
                default:
                    return false;
                }
            }
            return true; // Success!
        }
        return false; // Employee not found.
    }

    private void displayEmployee(Employee employee) {

        if (employee instanceof Secretary) {
            proff = "Secretary";
        } else if (employee instanceof Technician) {
            proff = "Technician";
        } else if (employee instanceof Programmer) {
            proff = "Programmer";
        } else {
            proff = "Unspecified";
        }
        System.out.printf("%3d %20s %10s %3d %10d %10d %10s%n", employee.getEmployeeId(), employee.getName(),
                employee.getGender(), employee.getage(), employee.getSalary(), employee.calculateBonus(), proff);

    }

    public void search(Integer employeeId, String name, Profession profession) {
        boolean found = false;
        for (Employee employee : employees) {
            boolean show = false;
            if (employeeId != null && employeeId.equals(employee.getEmployeeId())) {
                show = true;
            }
            if (name != null && name.equalsIgnoreCase(employee.getName())) {
                show = true;
            }
            if (profession != null) {
                switch (profession) {
                case SECRETARY:
                    if (employee instanceof Secretary) {
                        show = true;
                    }
                    break;
                case TECHNICIAN:
                    if (employee instanceof Technician) {
                        show = true;
                    }
                    break;
                case PROGRAMMER:
                    if (employee instanceof Programmer) {
                        show = true;
                    }
                    break;
                case INVALID:
                default:
                    break;
                }
            }
            if (show) {
                if (!found) {
                    found = true;
                    System.out.println(">>> Employee(s) found:");
                }
                displayEmployee(employee);
            }
        }
        if (!found) {
            System.out.println(">>> Employee(s) not found!");
        }
    }

    public void displayAll() {
        if (employees.isEmpty()) {
            System.out.println("[No employees registered]");
        } else {
            System.out.println("=== Displaying all " + employees.size() + " employees ===");
            System.out.printf("%3s %20s %10s %3s %10s %10s %10s%n", "ID", "NAME", "GENDER", "AGE", "SALARY", "BONUS",
                    "PROFESSION");
            for (Employee employee : employees) {
                displayEmployee(employee);
            }
        }
    }

    @Override
    public String toString() {
        return "EmployeeManager{" + "employees=" + employees + '}';
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

}
