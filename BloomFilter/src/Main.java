import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 04.09.2016.
 */
public class Main {
    public static void main(String[] args) {

        int n = 1 << 20;
        List<Integer> list = new ArrayList(n);
        for (int i = 0; i < list.size(); i++) {
            list.add((int) (Math.random() * Integer.MAX_VALUE));
        }

        BloomFilter bloomFilter = new BloomFilter(list, 0.1);

        for (int j = 0; j < 11; j++) {
            long avTime = 0;
            int queryCounts = 1 << (10 + j);

            for (int i = 0; i < queryCounts; i++) {
                int rand = (int) (Math.random() * Integer.MAX_VALUE);
                long start = System.nanoTime();
                bloomFilter.isInSet(rand);
                long time = System.nanoTime() - start;
                avTime += time;
            }

            System.out.print(avTime + "\n");
        }

//                System.out.println(time);
    }
}
