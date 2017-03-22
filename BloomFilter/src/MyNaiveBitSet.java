/**
 * Created by Ilgiz on 05.09.2016.
 */
public class MyNaiveBitSet {
    public static final int BIT_COUNT = 32;

    private int[] set;

    public MyNaiveBitSet(int size) {
        this.set = new int[size / BIT_COUNT + 1];

    }

    public void add(int x) {
        int bit = 1 << (x % 32);
        int place = x / 32;
        set[place] |= bit;
    }

    public boolean isConsist(int x) {
        if (set.length == 0)
            return false;

        int bit = 1 << (x % 32);
        int place = x / 32;

        if ((set[place] & bit) == 0) {
            return false;
        }

        return true;
    }

    public void remove(int x) {
        int bit = 1 << (x % 32);
        bit = ~bit;
        int place = x / 32;
        set[place] &= bit;
    }

    public int size() {
        return set.length;
    }
}
