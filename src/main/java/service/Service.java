package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Service {

    private ServiceOpenFile serviceOpenFile = new ServiceOpenFile();

    private String fileToString() throws IOException {
        BufferedReader bufferedReader = serviceOpenFile.openFileRead(serviceOpenFile.openFile());
        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()) {
            stringBuilder.append(bufferedReader.readLine());
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    public int countStrEntriesFile(String compareString) throws IOException {
        String fileStr = fileToString();
        int replaceAllCase = fileStr.length() - fileStr.replaceAll(compareString, "").length();
        System.out.println("count of entries = " + replaceAllCase);
        return replaceAllCase;
    }

    private boolean stringToFile(String writeStr) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(serviceOpenFile.openFileWrite(serviceOpenFile.openFile()));
        bufferedWriter.write(writeStr);
        bufferedWriter.flush();
        bufferedWriter.close();
        return true;
    }

    public void replaceStringFile(String replaceStr, String string) throws IOException {
        String fileStr = fileToString();
        if (stringToFile(fileStr.replaceAll(replaceStr, string))) {
            System.out.println("Success replaced");
        } else {
            System.out.println("Your replaced was failed");
        }
    }

}
