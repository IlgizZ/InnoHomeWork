/**
 * Created by Ilgiz on 30.08.2016.
 */
public class MyLinkedStack<E> {

    private int size;
    private Node first;

    private class Node{
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

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(E e){
        Node node = new Node(e);
        node.setNext(first);
        first = node;
        size++;
    }

    public E pop() {
        if (isEmpty())
            return null;
        Node first = this.first;
        this.first = first.next;
        first.setNext(null);
        size--;
        return first.getData();
    }

    public E top(){
        return first == null ? null : first.getData();
    }

}
