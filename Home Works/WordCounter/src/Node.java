/**
 * Created by Ilgiz on 26.09.2016.
 */
public class Node {
    private String word;
    private int count;

    public Node(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void incCountTo(int incOn) {
        this.count += incOn;
    }
}
