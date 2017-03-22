import javafx.geometry.Point2D;

/**
 * Created by Ilgiz on 01.09.2016.
 */
public class MonteCarlo {

    private boolean intersect(Point2D a, Point2D b, Point2D c, Point2D d) {
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

    private boolean isInside(MyArrayList<Point2D> polygon, Point2D point) {

        Point2D randomPoint = new Point2D(Math.random() * 10000, Math.random() * 10000);

        int intersectCount = 0;

        if (intersect(polygon.get(0), polygon.get(polygon.size() - 1), point, randomPoint)) {
            intersectCount++;
        }

        for (int i = 0; i < polygon.size() - 1; i++) {
            if (intersect(polygon.get(i), polygon.get(i + 1), point, randomPoint)) {
                intersectCount++;
            }
        }
        return intersectCount % 2 != 0;
    }

    private Range findXRange(MyArrayList<Point2D> polygon) {
        double min = polygon.get(0).getX();
        double max = min;
        for (int i = 1; i < polygon.size(); i++) {
            double currentX = polygon.get(i).getX();
            if (min > currentX) {
                min = currentX;
            } else if (max < currentX) {
                max = currentX;
            }
        }
        return new Range(min, max);
    }

    private Range findYRange(MyArrayList<Point2D> polygon) {
        double min = polygon.get(0).getY();
        double max = min;
        for (int i = 1; i < polygon.size(); i++) {
            double currentY = polygon.get(i).getY();
            if (min > currentY) {
                min = currentY;
            } else if (max < currentY) {
                max = currentY;
            }
        }
        return new Range(min, max);
    }

    public double calculateSquare(MyArrayList<Point2D> polygon) {
        double square = 0;
        double squarePar = 0;
        double eps = 0.0001;
        /**
         * Count of dots which inside polygon.
         */
        double k = 0;

        /**
         * Count of all dots.
         */
        double n = 0;

        Range rangeX = findXRange(polygon);
        Range rangeY = findYRange(polygon);

        squarePar = rangeX.getRange() * rangeY.getRange();
        double currentSquare = 0;
        int j = 0;
        do {
            square = currentSquare;
            for (int i = 0; i < 100000; i++) {
                Point2D point = new Point2D(rangeX.getRandomInRange(), rangeY.getRandomInRange());
                if (isInside(polygon, point)) {
                    k++;
                }
                n++;
            }
            j++;
            currentSquare = squarePar * k / n;
        } while (currentSquare - square > eps);
        System.out.println(j);
        return square;
    }

}
