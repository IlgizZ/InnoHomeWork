import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 31.08.2016.
 */
public class MyReaderWriter {
    private static List<Integer> toCheckList;


    public static void writeToFile(String fileName, String output) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName)))) {

            writer.write(output);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeToFile(String fileName, double output) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName)))) {

            writer.write(doubleConverter(output));
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String doubleConverter(Double d) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(d);
    }

    public static List<Integer> readIntegers(String fileName) throws Exception {
        List<Integer> result = new ArrayList();


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
            String str = bufferedReader.readLine();
            if (!str.equals(""))
                result = convertStringToIntegers(str);
            str = bufferedReader.readLine();
            toCheckList = convertStringToIntegers(str);

        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("\"Reading error:(\"");
        }

        return result;

    }

    private static List<Integer> convertStringToIntegers(String s) throws Exception {
        List<Integer> result = new ArrayList();

        if (s == null || s.equals(""))
            throw new Exception("Empty file!");

        String[] strArr = s.split(" ");
        for (String str : strArr) {
            result.add(Integer.valueOf(str));
        }

        return result;
    }

    public static List<Integer> getToCheckList() {
        return toCheckList;
    }
}
