package InputHandling;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class SystemInput {

    private final Scanner sc;

    public SystemInput() {
        sc = new Scanner(System.in);
    }

    private void handleBadInput() {

        sc.skip(".*");
        System.out.print("Bad input. Please reenter > ");
    }

    public double getDouble() {
        while (true) {
            try {
                double d = sc.nextDouble();
                sc.nextLine();
                return d;
            } catch (NoSuchElementException e) {
                handleBadInput();
            }
        }
    }

    public int getInt() {
        while (true) {
            try {
                int i = sc.nextInt();
                sc.nextLine();
                return i;
            } catch (NoSuchElementException e) {
                handleBadInput();
            }

        }
    }

    public String getString() {
        return sc.nextLine();
    }
}
