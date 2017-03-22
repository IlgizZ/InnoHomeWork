/**
 * Created by Ilgiz on 13.09.2016.
 */
public class Item implements Comparable {
    private int weight;
    private int coast;

    public Item(int weight, int coast) {
        this.weight = weight;
        this.coast = coast;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Item))
            return 1;

        double ratio1 = 1d * this.coast / this.weight;
        double ratio2 = 1d * ((Item) o).getCoast() / ((Item) o).getWeight();
        double eps = 0.000000001;

        if (ratio1 - ratio2 < eps)
            return 0;
        if (ratio1 < ratio2)
            return -1;
        return 1;
    }
}
