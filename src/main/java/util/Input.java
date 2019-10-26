package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);
    Output output;


    public String getLine() {
        System.out.println("Enter your string");
        return scanner.next();
    }

    public String getAnswer() {
        System.out.println("Enter your answer: ");
        return scanner.next();
    }

    public int getChoice() {
        System.out.println("Enter number of task (1, 2): ");
        try {
            return scanner.nextInt();
        }
        catch (InputMismatchException exception) {
            System.out.println(exception.getMessage());
        }
        return 0;
    }

}
