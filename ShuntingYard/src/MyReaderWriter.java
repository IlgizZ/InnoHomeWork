import java.io.*;

/**
 * Created by Ilgiz on 31.08.2016.
 */
public class MyReaderWriter {

    public static String readInput(String fileName) throws Exception {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
            String str = null;

            while ((str = bufferedReader.readLine()) != null) {
                sb.append(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("\"Reading error:(\"");
        }

        return sb.toString();
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
