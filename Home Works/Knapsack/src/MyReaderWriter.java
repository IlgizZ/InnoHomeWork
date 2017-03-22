import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 31.08.2016.
 */
public class MyReaderWriter {

    private static int maxWeight = -1;

    public static List<Item> readItems(String fileName) throws Exception {
        List<Item> items = new ArrayList();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
            String[] weights = bufferedReader.readLine().split(" ");
            String[] coasts = bufferedReader.readLine().split(" ");
            maxWeight = Integer.valueOf(bufferedReader.readLine());

            for (int i = 0; i < weights.length; i++) {
                items.add(new Item(Integer.valueOf(weights[i]),
                        Integer.valueOf(coasts[i])));
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("\"Reading error:(\"");
        }

        return items;
    }

    public static int readMaxWeight(String fileName) throws Exception {
        if (maxWeight == -1)
            readItems(fileName);
        return maxWeight;
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
