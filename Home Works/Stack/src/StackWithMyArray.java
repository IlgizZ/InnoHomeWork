/**
 * Created by Ilgiz on 04.10.2016.
 */
public class StackWithMyArray<E> implements Stack<E> {

    private MyArray<E> array;
    private int size;
    private int top;

    public StackWithMyArray() {
        this.top = -1;
        this.array = new MyArray();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() {
        return array.get(top);
    }

    @Override
    public void push(E data) {
        array.add(data);
        top++;
    }

    @Override
    public E pop() {
        if (size == 0)
            throw new IndexOutOfBoundsException("Stack is empty!!!");
        size--;
        return array.get(top--);
    }
}
