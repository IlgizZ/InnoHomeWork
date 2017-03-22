import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Ilgiz on 22.10.2016.
 */
public class Main {

    static String file;

    public static void main(String[] args) {
    }


    public static void generateData() {
        file = "1.csv";
        int n = 1;
        String[] fileNames = {"11", "21", "31", "111", "221", "331"};
        for (String fileName : fileNames) {
            doMagic(fileName);
        }
    }

    public static void doMagic(String fileName) {
        try {
            String potology = fileName.substring(0, 1);
            String[] numbers = MyReaderWriter.read(fileName).split(" |\t");
//                int degree1 = 2;
//                int degree2 = 5;

            int pixAccuracy = 5;
            int degreeAccuracy = 2;
            double[] doubles = new double[numbers.length];


            for (int i = 0; i < numbers.length; i++) {
                doubles[i] = Double.valueOf(numbers[i]);
            }

            NumberFormat formatter = new DecimalFormat("#0.000");

            for (int i = 0; i < 100; i++) {

                double r = randomize(pixAccuracy);
                StringBuilder sb = new StringBuilder();
                sb.append(potology);
                for (double d : doubles) {
                    sb.append("; ");
                    sb.append((d + r));
                }
                sb.append("\n");

                MyReaderWriter.writeToFile(file, sb.toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double randomizeDegree(double degreeAccuracy) {
        return Math.PI * (degreeAccuracy / 360);
    }

    private static double randomize(int pixAcuaracy) {
        return Math.random() * pixAcuaracy - pixAcuaracy / 2;
    }

}
