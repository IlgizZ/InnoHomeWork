/**
 * Created by Ilgiz on 01.09.2016.
 */
public class Range {
    private double a;
    private double b;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public Range() {
    }

    public Range(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getRandomInRange() {
        return a + (b - a) * Math.random();
    }

    public double getRange(){
        return b - a;
    }
}
