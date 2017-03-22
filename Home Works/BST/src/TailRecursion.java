/**
 * Created by Ilgiz on 01.11.2016.
 */
public class TailRecursion {

    private static long tailFactorial(long n, long factor) {
        return (n == 0) ? factor : tailFactorial(n - 1, factor * n);
    }


    /**
     * Tail recursion factorial, work on n <= 20.
     *
     * @param n
     * @return
     */

    public static long factorial(long n) {
        if (n < 1)
            return 0;
        return tailFactorial(n, 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(i + ": " + factorial(i));
        }
    }
}
