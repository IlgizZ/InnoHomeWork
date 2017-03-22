/**
 * Created by Ilgiz on 04.10.2016.
 */
public interface Stack<E> {
    int size();

    boolean isEmpty();

    E top();

    void push(E data);

    E pop();

}
