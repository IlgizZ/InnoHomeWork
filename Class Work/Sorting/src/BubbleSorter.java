/**
 * Created by Ilgiz on 20.09.2016.
 */
public class BubbleSorter {

    public void sort(int[] arr) {

        boolean swapped = true;
        int j = 0;
        int tmp;

        while (swapped) {
            swapped = false;
            j++;

            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }
}
