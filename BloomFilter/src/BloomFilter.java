import java.util.List;

/**
 * Created by Ilgiz on 03.09.2016.
 */

/**
 * The number of hash functions depends on false positive.
 * So, for false positive less than 13,5% min count of hash
 * functions is 3. Consequently we need at least 3 hash
 * functions.
 */
public class BloomFilter {
    private final int DEFAULT_HASH_COUNT = 3;
    private boolean needCoefficients;
    private int bitsCount;
    private int hashCount;
    private int[] shiftCoefficients;
    private MyNaiveBitSet set;

    public BloomFilter(List<Integer> set, double falsePositive) {
        bitsCount = (int) (-set.size() * Math.log(falsePositive) / Math.log(2) / Math.log(2)) + 1;
        this.set = new MyNaiveBitSet(bitsCount);
        hashCount = (int) (-Math.log(falsePositive) / Math.log(2));
        createCoefficients();
        creteSet(set);
    }

    public boolean isInSet(int x) {
        if (set.size() == 0)
            return false;

        int[] hashValues = createHashValues(x);

        for (int hash : hashValues) {
            if (!set.isConsist(hash)) {
                return false;
            }
        }

        return true;
    }

    public void add(int x) {
        for (int hash : createHashValues(x)) {
            set.add(hash);
        }
    }

    private void creteSet(List<Integer> set) {
        set.forEach(number -> {
            add(number);
        });
    }


    private int[] createHashValues(int x) {
        int[] hashValues = new int[hashCount];

        hashValues[0] = hash1(x);
        hashValues[1] = hash2(x);
        hashValues[2] = hash3(x);

        for (int i = DEFAULT_HASH_COUNT; i < hashCount; i++) {
            hashValues[i] = shiftHash(x, shiftCoefficients[i - DEFAULT_HASH_COUNT]);
        }

        return hashValues;
    }

    private void createCoefficients() {
        needCoefficients = hashCount > DEFAULT_HASH_COUNT;
        int size = 0;
        if (needCoefficients) {
            size = hashCount - DEFAULT_HASH_COUNT;
        }
        shiftCoefficients = new int[size];
        for (int i = 0; i < shiftCoefficients.length; i++) {
            shiftCoefficients[i] = (int) (Math.random() * MyNaiveBitSet.BIT_COUNT);
        }
    }

    private int hash1(int x) {
        return Math.abs(x) % bitsCount;
    }

    private int hash2(int x) {
        int magicNumber = Integer.MAX_VALUE / bitsCount * 2;
        return bitsCount / 2 + x / magicNumber;
    }

    private int hash3(int x) {
        return Math.abs(x * x) % bitsCount;
    }

    private int shiftHash(int x, int randomShift) {
        return Math.abs(~(x << randomShift)) % bitsCount;
    }
}
