import java.util.Arrays;

/**
 * Created by Ilgiz on 12.07.2016.
 */
public class MyArray<E> {

    public MyArray() {
        arr = (E[]) new Object[10];
    }

    private E[] arr;
    private int size;
    private int defaultCapacity = 10;
    private int maxCapacity = 10;

    private void checkIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index " + index + " is illegal. ");

    }

    private void extendArr() {
        maxCapacity *= 3;
        maxCapacity /= 2;
        arr = Arrays.copyOf(arr, maxCapacity);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean add(E e) {
        if (isEmpty()) {

            arr = (E[]) new Object[defaultCapacity];
            arr[size++] = e;
            return true;

        } else if (size == maxCapacity) {

            extendArr();

            arr[size++] = e;
            return true;

        } else {
            arr[size++] = e;
            return true;
        }
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(arr[i])) {
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

    public void clear() {
        arr = (E[]) new Object[defaultCapacity];
        size = 0;
    }

    public E get(int index) {
        checkIndex(index);
        return arr[index];
    }

    public E set(int index, E element) {
        checkIndex(index);
        E old = arr[index];
        arr[index] = element;
        return old;
    }

    public void add(int index, E element) {
        checkIndex(index);
        if (size + 1 == maxCapacity)
            extendArr();

        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        size++;
        arr[index] = element;
    }

    public E remove(int index) {
        checkIndex(index);
        E old = arr[index];

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size--] = null;
        return old;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o))
                return i;
        }
        return -1;
    }

}
