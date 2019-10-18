import java.io.*;

public class FileParser {

    private FileCore fileCore = new FileCore();

    private String fileToString(String fileName) throws IOException {
        BufferedReader bufferedReader = fileCore.openFileRead(fileCore.openFile(fileName));
        StringBuilder stringBuilder = new StringBuilder();

        while (bufferedReader.ready()) {
            stringBuilder.append(bufferedReader.readLine());
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    public int countStrEntriesFile(String fileName, String compareString) throws IOException {
        String fileStr = fileToString(fileName);
        int replaceAllCase = fileStr.length() - fileStr.replaceAll(compareString, "").length();
        System.out.println("count of entries = " + replaceAllCase);
        return replaceAllCase;
    }

    private boolean stringToFile(String fileName, String writeStr) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(fileCore.openFileWrite(fileCore.openFile(fileName)));

        bufferedWriter.write(writeStr);
        bufferedWriter.flush();//anti lose data
        bufferedWriter.close();

        return true;
    }

    void replaceStringFile(String fileName, String replaceStr, String string) throws IOException {
        String fileStr = fileToString(fileName);
        if (stringToFile(fileName, fileStr.replaceAll(replaceStr, string))) {
            System.out.println("Success replaced");
        }
        else {
            System.out.println("Your replaced was failed");
        }
    }

}
