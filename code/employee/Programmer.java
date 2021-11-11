package employee;

public class Programmer extends Employee {

    private static final double BONUS_MULTIPLIER = 2.3;

    public Programmer(Employee e) {
        super(e);
    }

    public Programmer(String name, int age, int salary, Gender gender) {
        super(name, age, salary, gender);
    }

    public int calculateBonus() {
        return (int) (this.getSalary() * BONUS_MULTIPLIER);
    }

}
