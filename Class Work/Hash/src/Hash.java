import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 06.09.2016.
 */
public class Hash {

    public static int hash(String s) {
        return s.hashCode() % 28629151;
    }

    public static void main(String[] args) {

        args = new String[1];
        if (args.length < 1) {
            System.err.println("Specify password!");
        } else {
            int a = 28629151;
            int b = 19847189;
            int length = 12;
            generatePasswords(a, b, length).forEach(s -> {
                if (s.length() == length && hash(s) == 19847189) {
                    System.out.print("Password is correct! Woohoo!");
                } else {
                    System.err.println("Password is incorrect >(");

                }
            });


        }
    }

    private static List<String> generatePasswords(int mod, int result, int length) {
        ArrayList passwords = new ArrayList();

        char[] password = new char[length];

        int[] polygon = new int[length];

        for (int i = 0; i < polygon.length; i++) {
            polygon[i] = 1;
        }

        for (int i = 0; i < polygon.length; i++) {
            for (int j = 0; j < i; j++) {
                polygon[j] *= 31;
            }
        }

        int hash = 0;

        if (Math.signum(result) * Math.signum(mod) > 0) {
            int diff = result;

            for (int i = 0; i < polygon.length; i++) {
                if (polygon[i] > 0) {
                    char count = 0;
                    while (diff - polygon[i] >= 0) {
                        diff -= polygon[i];
                        count++;
                    }
                    password[i] += count;
                }
            }
        } else {

        }

        passwords.add(new String(password));

        return passwords;
    }
}