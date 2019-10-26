package service;

import model.FileModel;

import java.io.*;

class ServiceOpenFile {

    private FileModel fileModel = new FileModel("D:\\fileParserTest.txt");
    BufferedReader openFileRead(File file) throws FileNotFoundException {
        if (file.exists()) {
            return new BufferedReader(new FileReader(file));
        }
        else {
            System.out.println("File does not exist");
            return null;
        }
    }

    BufferedWriter openFileWrite(File file) {
        try {
            if (file.exists()) {
                return new BufferedWriter(new FileWriter(file));
            } else {
                System.out.println("File does not exist");
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
