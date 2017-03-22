import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 31.08.2016.
 */
public class MyReaderWriter {

    public static List<String> read(String fileName) throws Exception {
        List<String> sb = new ArrayList();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                sb.add(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("\"Reading error:(\"");
        }

        return sb;
    }

    public static String[] readRussia(String fileName) throws Exception {
        String[] sb = new String[2];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
            String str = bufferedReader.readLine();
            sb[0] = str;
            str = bufferedReader.readLine();
            sb[1] = str;
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("\"Reading error:(\"");
        }

        return sb;
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