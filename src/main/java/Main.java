import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileParser fileParser = new FileParser();
        //fileParser.countStrEntriesFile("D:\\fileParserTest.txt", "1");
        fileParser.replaceStringFile("D:\\fileParserTest.txt", "1", "000");

    }

}
