/**
 * Created by Ilgiz on 20.09.2016.
 */
public class SelectionSorter {

    public void sort(int[] arr) {
        int i, j, minIndex, tmp;
        int n = arr.length;

        for (i = 0; i < n - 1; i++) {
            minIndex = i;

            for (j = i + 1; j < n; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            if (minIndex != i) {
                tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }

}

