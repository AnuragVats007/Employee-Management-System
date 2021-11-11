package employee;

public abstract class Employee {

    private String name;
    private int age;
    private int salary;
    private Gender gender;
    private final int employeeId;

    static int idGenerator = 1;

    protected Employee(Employee e) {
        name = e.name;
        age = e.age;
        salary = e.salary;
        gender = e.gender;
        employeeId = e.employeeId;
    }

    protected Employee(String name, int age, int salary, Gender gender) {
        this.employeeId = idGenerator++;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
    }

    public abstract int calculateBonus();

    public String toString() {
        return System.lineSeparator() + "Employee{" + "name=" + name + ", age=" + age + ", salary=" + salary
                + ", gender=" + gender + ", employeeId=" + employeeId + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getage() {
        return age;
    }

    public void setage(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getEmployeeId() {
        return employeeId;
    }

}
