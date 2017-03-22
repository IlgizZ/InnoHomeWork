import java.util.List;

/**
 * Created by Ilgiz on 13.09.2016.
 */
public class BruteForce {
    private List<Item> items;
    private int maxCoast;
    private long subset;
    private long set;
    private int maxWeight;

    public BruteForce(List<Item> items, int maxWeight) {
        this.items = items;
        this.maxWeight = maxWeight;
    }

    public int getMaxCoast() {
        return maxCoast;
    }


    public long getSubset() {
        return subset;
    }


    public static void main(String[] args) {
        try {

            List<Item> items = MyReaderWriter.readInput("input.txt");
            int maxWeight = 50 * items.size();
            BruteForce bruteForce = new BruteForce(items, maxWeight);
            long resultSubSet = bruteForce.solveKnapsack();
            int result = bruteForce.getMaxCoast();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long solveKnapsack() {
        set = 1;
        while (set != 0)
            solve();
        return this.subset;
    }

    private void solve() {
        int coast = 0;
        int weight = 0;
        for (int i = 0; i < items.size(); i++) {
            if (((1 << i) & set) == 1) {
                coast += items.get(i).getCoast();
                weight += items.get(i).getWeight();
            }
        }
        if (coast > this.maxCoast && weight <= maxWeight) {
            this.maxCoast = coast;
            this.subset = set;
        }
        set++;
    }

}
