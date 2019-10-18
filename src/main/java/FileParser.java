import java.io.*;

public class FileParser {

    private BufferedReader openFileRead(File file) throws FileNotFoundException {
        if (file.exists()) {
            return new BufferedReader(new FileReader(file));
        }
        else {
            System.out.println("File does not exist");
            return null;
        }
    }

    private BufferedWriter openFileWrite(File file) throws IOException {
        if (file.exists()) {
            return new BufferedWriter(new FileWriter(file));
        }
        else {
            System.out.println("File does not exist");
            return null;
        }
    }

    private File openFile(String fileName) {
        return new File(fileName);
    }

    private String fileToString(String fileName) throws IOException {
        BufferedReader bufferedReader = openFileRead(openFile(fileName));
        StringBuilder stringBuilder = new StringBuilder();

        while (bufferedReader.ready()) {
            stringBuilder.append(bufferedReader.readLine());
        }
        final String s = stringBuilder.toString();
        return s;
    }

    public int countStrEntriesFile(String fileName, String compareString) throws IOException {
        String fileStr = fileToString(fileName);
        int countEntries = 0;
        for (int i = 0; i < fileStr.length(); i++) {
            if (fileStr.charAt(i) == compareString.charAt(0)) {
                for (int j = 0, ii = i; j < compareString.length() && ii < fileStr.length(); ii++ ,j++) {
                    if (fileStr.charAt(ii) == compareString.charAt(j)) {
                        if (j == (compareString.length() - 1))
                            countEntries++;
                        else
                            break;
                    }
                }
            }
        }
        return countEntries;
    }

    private boolean stringToFile(String fileName, String writeStr) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(openFileWrite(openFile(fileName)));

        bufferedWriter.write(writeStr);
        bufferedWriter.flush();//anti lose data
        bufferedWriter.close();

        return true;
    }

    public void replaceStringFile(String fileName, String replaceStr, String string) throws IOException {
        String fileStr = fileToString(fileName);
        if (stringToFile(fileName, fileStr.replaceAll(replaceStr, string))) {
            System.out.println("Success replaced");
        }
        else {
            System.out.println("Your replaced was failed");
        }
    }

}
