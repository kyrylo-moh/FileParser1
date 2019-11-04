package util;

import java.io.File;

public class Validator {

    public boolean isPositiveNum(int num) {
        return num <= 0;
    }

    public boolean isFileExist(File file) {
        return  (file.exists() && file.isFile());
    }

    public boolean isEmptyFile(File file) {
        return (file.length() != 0);
    }

}
