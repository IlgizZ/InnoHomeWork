import java.io.*;

/**
 * Created by Ilgiz on 31.08.2016.
 */
public class MyReaderWriter {

    private static int windowSize = -1;

    public static int[] readSignals(String fileName) throws Exception {
        int[] signals = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
            String[] signalsStr = bufferedReader.readLine().split(" ");
            windowSize = Integer.valueOf(bufferedReader.readLine());

            signals = new int[signalsStr.length];

            for (int i = 0; i < signalsStr.length; i++) {
                signals[i] = Integer.valueOf(signalsStr[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("\"Reading error:(\"");
        }

        return signals;
    }

    public static int readWindowSize(String fileName) throws Exception {
        if (windowSize == -1)
            readSignals(fileName);
        return windowSize;
    }

    public static void writeToFile(String fileName, String output) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName)))) {

            writer.write(output);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
