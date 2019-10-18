import java.io.*;

class FileCore {

    BufferedReader openFileRead(File file) throws FileNotFoundException {
        if (file.exists()) {
            return new BufferedReader(new FileReader(file));
        }
        else {
            System.out.println("File does not exist");
            return null;
        }
    }

    BufferedWriter openFileWrite(File file) throws IOException {
        if (file.exists()) {
            return new BufferedWriter(new FileWriter(file));
        }
        else {
            System.out.println("File does not exist");
            return null;
        }
    }

    File openFile(String fileName) {
        return new File(fileName);
    }

}
