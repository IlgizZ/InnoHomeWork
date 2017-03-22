import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 31.08.2016.
 */
public class MyReaderWriter {

    public static String[] readText(String fileName) throws Exception {
        List<String> lines = new ArrayList();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                lines.add(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("\"Reading error:(\"");
        }

        return lines.toArray(new String[lines.size()]);
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
