import com.sun.javafx.scene.control.skin.VirtualFlow;
import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 30.08.2016.
 */
public class Main {

    private static boolean intersect(Point2D a, Point2D b, Point2D c, Point2D d){
        double[][] A = new double[2][2];
        A[0][0] = b.getX() - a.getX();
        A[1][0] = b.getY() - a.getY();
        A[0][1] = c.getX() - d.getX();
        A[1][1] = c.getY() - d.getY();

        double det0 = A[0][0] * A[1][1] - A[1][0] * A[0][1];

        double detU = (c.getX() - a.getX()) * A[1][1] - (c.getY() - a.getY()) * A[0][1];
        double detV = A[0][0] * (c.getY() - a.getY()) - A[1][0] * (c.getX() - a.getX());

        double u = detU / det0;
        double v = detV / det0;
        return u > 0 && u < 1 && v > 0 && v < 1;

    }

    public static boolean isInside(List<Point2D> polygon, Point2D point){

        Point2D randomPoint = new Point2D(Math.random() * 10000, Math.random() * 10000);

        int intersectCount = 0;

        if (intersect(polygon.get(0), polygon.get(polygon.size() - 1), point, randomPoint)){
            intersectCount++;
        }

        for (int i = 0; i < polygon.size() - 1; i++) {
            if (intersect(polygon.get(i), polygon.get(i + 1), point, randomPoint)){
                intersectCount ++;
            }
        }
        return intersectCount % 2 != 0;
    }

    public static void main(String[] args) {
        List<Point2D> polygon = new ArrayList();

        polygon.add(new Point2D(1, 2));
        polygon.add(new Point2D(6, 2));
        polygon.add(new Point2D(6, 1));
        polygon.add(new Point2D(1, 1));

        System.out.println(isInside(polygon, new Point2D(5, 1.9)));

    }
}
