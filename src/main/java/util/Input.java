package util;

import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);
    private Output output = new Output();
    private Validator validator = new Validator();

    public String getLine() {
        System.out.println("Enter your string");
        return scanner.next();
    }

    public String getAnswer() {
        System.out.println("Enter your answer: ");
        return scanner.next();
    }

    public String getPath() {
        System.out.println("Enter your path file: ");
        return scanner.next();
    }

    public int getChoice() {
        System.out.println("Enter number of task (1, 2): ");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
            if (validator.isPositiveNum(num)) {
                output.printNotZero();
                scanner.next();
                num = getChoice();
            }
        } else {
            scanner.next();
            num = getChoice();
        }
        return num;
    }

}
