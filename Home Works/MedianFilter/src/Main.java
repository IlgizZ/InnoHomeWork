import java.util.Arrays;

/**
 * Created by Ilgiz on 26.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            int[] signals = MyReaderWriter.readSignals("input.txt");
            int windowSize = MyReaderWriter.readWindowSize("input.txt");

            MedianFilter medianFilter = new MedianFilter(signals);
            signals = medianFilter.filter(windowSize);

            StringBuilder sb = new StringBuilder();
            Arrays.stream(signals).forEach(signal -> {
                sb.append(signal);
                sb.append(" ");
            });

            MyReaderWriter.writeToFile("output.txt", sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
