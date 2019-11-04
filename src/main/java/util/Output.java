package util;

public class Output {

    public void printQuestion() {
        System.out.println("Do you want continue? [Yes/No]");
    }

    public void printFileInstruction() {
        System.out.println("Please enter path to file");
    }

    public void printFileEmpty() {
        System.out.println("File which you enter is empty");
    }

    public void printFileExist() {
        System.out.println("File which you enter is not exist");
    }

    public void printNotZero() {
        System.out.println("Your value must be not less than 0");
    }
}
