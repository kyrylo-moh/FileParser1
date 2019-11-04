package service;

import model.FileModel;
import util.Input;
import util.Output;
import util.Validator;

import java.io.*;

class ServiceOpenFile {

    private Input input = new Input();
    private Output output = new Output();
    private Validator validator = new Validator();
    private FileModel fileModel = new FileModel(input.getPath());

    BufferedReader openFileRead(File file) throws FileNotFoundException {
        if (validator.isFileExist(file)) {
            return new BufferedReader(new FileReader(file));
        }
        else {
            output.printFileExist();
            return null;
        }
    }

    BufferedWriter openFileWrite(File file) {
        try {
            if (validator.isFileExist(file)) {
                return new BufferedWriter(new FileWriter(file));
            } else {
                output.printFileExist();
                return null;
            }
        } catch (IOException e) {
            System.out.println("Error message: " + e);
            return null;
        }
    }

    File openFile() {
            return new File(fileModel.getPathToFile());
    }

}
