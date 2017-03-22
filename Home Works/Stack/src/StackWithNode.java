/**
 * Created by Ilgiz on 04.10.2016.
 */
public class StackWithNode<E> implements Stack<E> {
    private class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    private int size;
    private Node top;

    @Override
    public int size() {
        return size();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() {
        return top.data;
    }

    @Override
    public void push(E data) {
        Node newNode = new Node(data);
        if (size != 0) {
            newNode.next = top;
        }
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (size == 0)
            throw new IndexOutOfBoundsException("Stack is empty!!!");
        E data = top.data;
        top = top.next;
        size--;
        return data;
    }
}
