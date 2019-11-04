package controller;

import service.Service;
import util.Input;
import util.Instruction;
import util.Output;
import util.Validator;

import java.io.IOException;

public class Controller {

    private Input input = new Input();
    private Service service = new Service();
    private Instruction instruction = new Instruction();
    private Output output = new Output();
    private Validator validator = new Validator();

    private void getCountStrEntriesFile() {
        try {
            service.countStrEntriesFile(input.getLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getReplaceStringFile() {
        try {
            service.replaceStringFile(input.getLine(), input.getLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void choice() {

        instruction.getInstruction();
        int choiceNum = input.getChoice();
        while (validator.isPositiveNum(choiceNum)) {
            choiceNum = input.getChoice();
        }
        switch (choiceNum) {
            case 1:
                getCountStrEntriesFile();
                break;
            case 2:
                getReplaceStringFile();
                break;
            default:
                instruction.getInstruction();
        }
    }

    public void runController() {
        String answer;
        do {
            choice();
            output.printQuestion();
            answer = input.getAnswer();
        } while (answer.equalsIgnoreCase("y") ||
                answer.equalsIgnoreCase("yes"));
    }

}
