/**
 * Created by Ilgiz on 30.08.2016.
 */
public class MyLinkedQueue<E> {
    private int size;
    private Node first;
    private Node last;

    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) {
        Node node = new Node(e);
        if (isEmpty()) {
            first = last = node;
            size++;
            return;
        }
        last.next = node;
        last = node;
        size++;
    }

    public E dequeue() {
        if (isEmpty())
            return null;
        Node first = this.first;
        this.first = first.next;
        first.setNext(null);
        size--;
        return first.getData();
    }

    public E first() {
        return first == null ? null : first.getData();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = first;
        while (node != null) {
            stringBuilder.append(node.getData().toString());
            stringBuilder.append(" ");
            node = node.getNext();
        }
        return stringBuilder.toString();
    }
}
