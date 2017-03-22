/**
 * Created by Ilgiz on 26.09.2016.
 */
public class MedianFilter {
    private int[] window;
    private int[] signals;

    public MedianFilter(int[] signals) {
        this.signals = signals;
    }

    private int calculateMedian(int index, int windowSize) {
        window = new int[windowSize];

        int signalLastIndex = signals.length - 1;
        int outOfLeft = windowSize / 2 - index;
        int outOfRight = index + windowSize / 2 - signalLastIndex;

        // left boundary
        if (outOfLeft > 0) {

            for (int i = 0; i < outOfLeft; i++) {
                window[i] = signals[0];
            }

            for (int i = outOfLeft; i < window.length; i++) {
                window[i] = signals[i - outOfLeft];
            }
            // right boundary
        } else if (outOfRight > 0) {
            int n = 0;

            for (int i = 0; i < window.length - outOfRight; i++) {
                window[n++] = signals[i + index - windowSize / 2];
            }

            for (int i = 0; i < outOfRight; i++) {
                window[n++] = signals[signalLastIndex];
            }

            //all right, just copy
        } else {
            for (int i = 0; i < window.length; i++) {
                window[i] = signals[index + i - windowSize / 2];
            }
        }
        sort(window);
        return window[windowSize / 2];
    }

    private void bubbleSort(int[] arr) {

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

    private void sort(int[] arr) {
        int smallArrSize = 100;

        if (arr.length < smallArrSize)
            bubbleSort(arr);
        else
            quickSort(arr);
    }

    private void quickSort(int[] a) {
        qsort(a, 0, a.length - 1);
    }

    private void qsort(int a[], int left, int right) {
        int l = left;
        int r = right;
        int tmp = 0;
        int randomElement = (int) (Math.random() * (r - l) + l);
        int pivot = a[randomElement];

        while (l <= r) {
            while ((a[l] < pivot) && (l <= right)) l++;
            while ((a[r] > pivot) && (r >= left)) r--;

            if (l <= r) {

                tmp = a[l];
                a[l] = a[r];
                a[r] = tmp;

                l++;
                r--;
            }
        }

        if (r > left) qsort(a, left, r);
        if (l < right) qsort(a, l, right);
    }

    public int[] filter(int windowSize) {
        int[] result = new int[signals.length];

        for (int i = 0; i < signals.length; i++) {
            result[i] = calculateMedian(i, windowSize);
        }

        return result;
    }

}
