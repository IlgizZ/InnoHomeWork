import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 22.09.2016.
 */
public class Knapsack {
    private List<Item> items;
    private int maxCoast;

    public Knapsack(List<Item> items) {
        this.items = items;
        maxCoast = -1;
    }

    private List<Item> findItemNumbers(int[][] table) {
        List<Item> result = new ArrayList();
        int i = table.length - 1;
        int j = table[0].length - 1;
        int maxCoast = table[i][j];
        this.maxCoast = maxCoast;

        while (maxCoast != 0) {
            if (i > 0 && table[i - 1][j] == table[i][j]) {
                i--;
                continue;
            }
            result.add(items.get(i));
            j -= items.get(i).getWeight();
            maxCoast -= items.get(i).getCoast();
            i--;
        }

        return result;
    }

    private int[][] fillTable(int maxWeight) {
        int itemsCount = items.size();
        int[][] table = new int[itemsCount][maxWeight + 1];
        //first column must be zero

        //fill first row
        for (int i = 1; i < maxWeight + 1; i++) {
            int currentWeight = items.get(0).getWeight();
            if (currentWeight <= i)
                table[0][i] = items.get(0).getCoast();
        }

        //begin from second row fill table
        for (int i = 1; i < itemsCount; i++) {
            for (int j = 0; j < maxWeight + 1; j++) {
                int currentCoast = items.get(i).getCoast();
                int currentWeight = items.get(i).getWeight();

                if (currentWeight > j) {
                    table[i][j] = table[i - 1][j];
                    continue;
                }

                int prevCoastWhichFits = table[i - 1][j - currentWeight];
                int prevCoastFromTop = table[i - 1][j];

                table[i][j] = Math.max(currentCoast + prevCoastWhichFits, prevCoastFromTop);
            }
        }

        return table;
    }

    public List<Item> fillKnapsack(int maxWeight) {
        int[][] table = fillTable(maxWeight);

        List<Item> result = findItemNumbers(table);

        return result;
    }

    /**
     * @return max coast of Knapsack or -1 if it hasn't solve
     */
    public int getMaxCoast() {
        return maxCoast;
    }
}
