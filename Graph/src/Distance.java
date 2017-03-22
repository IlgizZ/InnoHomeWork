/**
 * Created by Ilgiz on 22.11.2016.
 */
public class Distance implements Countable {
    private double distance;
    private double time;
    private double cost;
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Distance(double distance, double time, double cost) {
        this.distance = distance;
        this.time = time;
        this.cost = cost;
    }


}
