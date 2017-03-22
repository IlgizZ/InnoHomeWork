import java.util.ArrayList;

/**
 * Created by Ilgiz on 26.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            String[] lines = MyReaderWriter.readText("input.txt");
            WordCounter wordCounter = new WordCounter(lines);
            MyReaderWriter.writeToFile("output.txt", wordCounter.getMaxString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
