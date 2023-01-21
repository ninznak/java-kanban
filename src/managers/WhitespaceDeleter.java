package managers;

public class WhitespaceDeleter {

    public static String[] clean(String[] dataArray) {
        String[] cleanedArray = new String[dataArray.length];

        for (int i = 0; i < dataArray.length; i++) {
            cleanedArray[i] = dataArray[i].strip();
        }
        return cleanedArray;
    }
}
