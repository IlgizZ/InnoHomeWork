import java.util.Arrays;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class ArrayGenerator {

    public static int[] generateArray(int n) {
        int[] result = new int[n];
        int maxInt = 10000;

        for (int i = 0; i < result.length; i++) {
            int random = (int) (Math.random() * maxInt);
            result[i] = random;
        }

        return result;
    }

    public static int[] generateSortedArray(int n) {
        int[] result = generateArray(n);
        Arrays.sort(result);
        return result;
    }

    public static int[] generateReverseSortedArray(int n) {
        int[] tmp = generateArray(n);
        Arrays.sort(tmp);
        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = tmp[n - i - 1];
        }
        return result;
    }
}
