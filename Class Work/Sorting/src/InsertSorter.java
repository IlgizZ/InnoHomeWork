/**
 * Created by Ilgiz on 20.09.2016.
 */
public class InsertSorter {

    void sort(int[] arr) {
        int i, j, newValue;

        for (i = 1; i < arr.length; i++) {
            newValue = arr[i]; // we will sink this element
            j = i;

            while (j > 0 && arr[j - 1] > newValue) { // until it reaches its place
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = newValue; // swap in outer loop
        }
    }

}
