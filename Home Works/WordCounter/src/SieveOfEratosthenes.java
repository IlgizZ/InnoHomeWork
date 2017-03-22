import java.util.Arrays;

/**
 * Created by Ilgiz on 26.09.2016.
 */
public class SieveOfEratosthenes {
    private boolean[] isPrimary;
    private int n;
    private static SieveOfEratosthenes sieveOfEratosthenes;

    public synchronized static SieveOfEratosthenes getInstance(int n) {
        if (sieveOfEratosthenes == null)
            sieveOfEratosthenes = new SieveOfEratosthenes(n);
        return sieveOfEratosthenes;
    }

    private SieveOfEratosthenes(int n) {
        this.n = n;
        sieve();
    }

    private void sieve() {
        if (n == 0) {
            isPrimary = new boolean[0];
            return;
        }

        isPrimary = new boolean[2 * n + 1];
        Arrays.fill(isPrimary, true);
        isPrimary[0] = false;
        isPrimary[1] = false;

        for (int i = 2; i < isPrimary.length; i++) {
            if (isPrimary[i]) {
                for (int j = 2; i * j < isPrimary.length; j++) {
                    isPrimary[i * j] = false;
                }
            }
        }

    }

    public int getNextPrimary(int n) {
        if (n == 0)
            return 0;

        for (int i = n + 1; i < isPrimary.length; i++) {
            if (isPrimary[i])
                return i;
        }
        this.n = n;
        sieve();
        return getNextPrimary(n);
    }

    public int getPrevPrimary(int n) {
        if (n == 0)
            return 0;

        for (int i = n - 1; i >= 0; i--) {
            if (isPrimary[i])
                return i;
        }

        return 1;
    }
}
