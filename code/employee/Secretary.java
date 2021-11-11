package employee;

public class Secretary extends Employee {

    private static final double BONUS_MULTIPLIER = 1.4;

    public Secretary(Employee e) {
        super(e);
    }

    public Secretary(String name, int age, int salary, Gender gender) {
        super(name, age, salary, gender);
    }

    public int calculateBonus() {
        return (int) (this.getSalary() * BONUS_MULTIPLIER);
    }

}
