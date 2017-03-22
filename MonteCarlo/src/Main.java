import javafx.geometry.Point2D;

/**
 * Created by Ilgiz on 01.09.2016.
 */
public class Main {

    public static void main(String[] args) {

        try {
            MyArrayList<Point2D> polygon = MyReaderWriter.readPoints("input.txt");
            MyReaderWriter.writeToFile("output.txt", new MonteCarlo().calculateSquare(polygon));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
