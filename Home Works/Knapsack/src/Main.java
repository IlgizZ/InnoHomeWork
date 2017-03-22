import java.util.List;

/**
 * Created by Ilgiz on 22.09.2016.
 */
public class Main {
    public static void main(String[] args) {

        try {
            Knapsack knapsack = new Knapsack(MyReaderWriter.readItems("input.txt"));
            int maxWeight = MyReaderWriter.readMaxWeight("input.txt");

            List<Item> knapsackItems = knapsack.fillKnapsack(maxWeight);

            MyReaderWriter.writeToFile("output.txt", String.valueOf(knapsack.getMaxCoast()));

            System.out.println("(weight; coast)");
            knapsackItems.forEach(item -> {
                System.out.println("(" + item.getWeight() + "; " + item.getCoast() + ") ");
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
