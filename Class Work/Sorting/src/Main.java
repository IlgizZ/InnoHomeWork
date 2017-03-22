import java.util.Arrays;

/**
 * Created by Ilgiz on 20.09.2016.
 */

public class Main {

    public static void main(String[] args) {
        int n = 128;

        System.out.println("Random array:");
        System.out.println();

        for (int i = 0; i < 10; i++) {
            doTest(ArrayGenerator.generateArray(n));
            n <<= 1;
        }

        System.out.println("Sorted array:");
        System.out.println();

        n = 128;
        for (int i = 0; i < 10; i++) {
            doTest(ArrayGenerator.generateSortedArray(n));
            n <<= 1;
        }

        n = 128;
        System.out.println("Reverse-Sorted array:");
        System.out.println();

        for (int i = 0; i < 10; i++) {
            doTest(ArrayGenerator.generateReverseSortedArray(n));
            n <<= 1;
        }
    }

    private static int[] arrayCopy(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];
        }
        return b;
    }

    private static void doTest(int[] a) {
        int[] b = null;

        BubbleSorter bubbleSorter = new BubbleSorter();
        SelectionSorter selectionSorter = new SelectionSorter();
        InsertSorter insertSorter = new InsertSorter();
        Qsort qsort = new Qsort();

        System.out.println(a.length);

        b = arrayCopy(a);
        long start = System.currentTimeMillis();
        bubbleSorter.sort(b);
        System.out.println((System.currentTimeMillis() - start));
//        System.out.println("Bubble sort on: " + a.length + " elements " + (System.currentTimeMillis() - start));

        b = arrayCopy(a);
        start = System.currentTimeMillis();
        selectionSorter.sort(b);
//        System.out.println("Selection sort on: " + a.length + " elements " + (System.currentTimeMillis() - start));
        System.out.println((System.currentTimeMillis() - start));

        b = arrayCopy(a);
        start = System.currentTimeMillis();
        insertSorter.sort(b);
//        System.out.println("Insert sort on: " + a.length + " elements " + (System.currentTimeMillis() - start));
        System.out.println((System.currentTimeMillis() - start));

        b = arrayCopy(a);
        start = System.currentTimeMillis();
        qsort.sort(b);
//        System.out.println("Quick sort on: " + a.length + " elements " + (System.currentTimeMillis() - start));
        System.out.println((System.currentTimeMillis() - start));

        b = arrayCopy(a);
        start = System.currentTimeMillis();
        Arrays.sort(b);
//        System.out.println("Tim sort on: " + a.length + " elements " + (System.currentTimeMillis() - start));
        System.out.println((System.currentTimeMillis() - start));
        System.out.println();

    }
}
