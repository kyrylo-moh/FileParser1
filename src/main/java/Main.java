import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileParser fileParser = new FileParser();
        fileParser.replaceStringFile("D:\\fileParserTest.txt", "00", "fs");

    }

}
