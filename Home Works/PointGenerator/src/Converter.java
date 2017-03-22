/**
 * Created by Ilgiz on 22.10.2016.
 */
public class Converter {

    int test() {

        int w = 480;
        int h = 640;

        Point2f[] p1 = new Point2f[7];

        Point2f[][] points = new Point2f[3][7];

        //640 x 480 vertical


        points[0][0] = new Point2f(230, 430);
        points[0][1] = new Point2f(250, 430);
        points[0][2] = new Point2f(360, 400);
        points[0][3] = new Point2f(380, 300);
        points[0][4] = new Point2f(240, 350);
        points[0][5] = new Point2f(100, 300);
        points[0][6] = new Point2f(120, 400);


        points[1][0] = new Point2f(340, 430);
        points[1][1] = new Point2f(340, 430);
        points[1][4] = new Point2f(350, 350);
        points[1][5] = new Point2f(240, 300);
        points[1][6] = new Point2f(280, 300);


        points[2][0] = new Point2f(140, 430);
        points[2][1] = new Point2f(140, 430);
        points[2][2] = new Point2f(200, 340);
        points[2][3] = new Point2f(240, 300);
        points[2][4] = new Point2f(130, 350);

        Point3f[] p = new Point3f[7];
        int dimensionX, dimensionY, dimensionZ, front, right, left;

        dimensionX = front = 0;
        dimensionY = right = 1;
        dimensionZ = left = 2;

        for (int i = 0; i < 7; i++) {
            p[i] = new Point3f();
            p[i].x = points[front][i].x;
            p[i].y = h - points[front][i].y;

        }

        p[0].z = w - points[right][0].x;
        p[1].z = w - points[left][1].x;
        p[2].z = points[left][2].x;
        p[3].z = points[left][3].x;
        p[4].z = points[left][4].x;
        p[5].z = w - points[right][5].x;
        p[6].z = w - points[right][6].x;


        for (int i = 0; i < 7; i++) {
            System.out.print(p[i].x);
            System.out.print("  " + p[i].y);
            System.out.print("  " + p[i].z);
            System.out.println();
        }


        return 0;
    }


    Point3f[] calculateCoordinate(Point2f[][] points, int w, int h) {
        Point3f[] result = new Point3f[7];
        int dimensionX, dimensionY, dimensionZ, front, right, left;

        dimensionX = front = 0;
        dimensionY = right = 1;
        dimensionZ = left = 2;

        for (int i = 0; i < 7; i++) {
            result[i] = new Point3f();
            result[i].x = points[front][i].x;
            result[i].y = h - points[front][i].y;

        }


        result[0].z = w - points[right][0].x;
        result[1].z = w - points[right][0].x;
        result[2].z = points[left][2].x;
        result[3].z = points[left][3].x;
        result[4].z = points[left][4].x;
        result[5].z = w - points[right][5].x;
        result[6].z = w - points[right][6].x;


        return result;
    }

    boolean checkCameraDistance(Point2f[][] points, int w) {
        int accuracy = 3;
        boolean cond1 = Math.abs(w - points[1][0].x - points[2][0].x) <= accuracy;
        boolean cond2 = Math.abs(points[2][4].x - w - points[1][4].x) <= accuracy;
        if (cond1 && cond2) {
            return true;
        }
        return false;

    }
}