import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ilgiz on 01.09.2016.
 */
public class MyArrayList<E> {

    private E[] arr;
    private int size;
    private int defaultCapacity = 10;
    private int maxCapacity = 10;

    public MyArrayList() {
        arr = (E[]) new Object[defaultCapacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        rangeCheck(index);
        return arr[index];
    }

    public E set(int index, E element) {
        rangeCheck(index);

        E oldValue = arr[index];
        arr[index] = element;
        return oldValue;
    }

    public boolean add(E e) {

        if (isEmpty()) {
            arr = (E[]) new Object[defaultCapacity];
            arr[size++] = e;
        } else if (size == maxCapacity) {
            maxCapacity *= 3;
            maxCapacity /= 2;

            arr = Arrays.copyOf(arr, maxCapacity);
            arr[size++] = e;
        } else {
            arr[size++] = e;
        }

        return true;
    }

    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(arr[i])) {
                size--;
                for (int j = i; j < size; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[size] = null;
                return true;
            }
        }
        return false;
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }
}
