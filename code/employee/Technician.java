package employee;

public class Technician extends Employee {

    private static final double BONUS_MULTIPLIER = 1.7;

    public Technician(Employee e) {
        super(e);
    }

    public Technician(String name, int age, int salary, Gender gender) {
        super(name, age, salary, gender);
    }

    public int calculateBonus() {
        return (int) (this.getSalary() * BONUS_MULTIPLIER);
    }
}
