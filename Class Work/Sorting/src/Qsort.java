/**
 * Created by Ilgiz on 20.09.2016.
 */
public class Qsort {

    public void sort(int[] a) {
        qsort(a, 0, a.length - 1);
    }

    private void qsort(int a[], int left, int right) {
        int l = left;
        int r = right;
        int foo = 0;
        int randomElement = (int) (Math.random() * (r - l) + l);
        int pivot = a[randomElement];

        while (l <= r) {
            while ((a[l] < pivot) && (l <= right)) l++;
            while ((a[r] > pivot) && (r >= left)) r--;

            if (l <= r) {
//                a[l] = a[l] ^ a[r];
//                a[r] = a[l] ^ a[r];
//                a[l] = a[l] ^ a[r];

                foo = a[l];
                a[l] = a[r];
                a[r] = foo;
                l++;
                r--;
            }
        }

        if (r > left) qsort(a, left, r);
        if (l < right) qsort(a, l, right);
    }

}
