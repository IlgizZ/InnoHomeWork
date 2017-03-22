import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 01.11.2016.
 */
public class Main {

    public static BST<Character, Integer> generateRandomBST() {
        BST<Character, Integer> tree = new BST<>();
        int diff = 'z' - 'a' + 1;
        char a = 'a';
        List<Character> alphabet = new ArrayList();
        for (char i = 'a'; i <= 'z'; i++) {
            alphabet.add(i);

        }


        while (!alphabet.isEmpty()) {
            char rand = (char) (a + (char) (diff * Math.random()));

            while (!alphabet.contains(rand))
                rand = (char) (a + (char) (diff * Math.random()));

            tree.insert(rand, (int) (100000 * Math.random()));

            alphabet.remove(new Character(rand));
        }

        return tree;
    }

    public static void main(String[] args) {
        BST<Character, Integer> tree = generateRandomBST();

        tree.printContent();

        for (char c = 'z'; c >= 'a'; c--) {
            System.out.print("(" + c + "; " + tree.search(c) + ")  ");
        }

        System.out.println();

        System.out.println("Height: " + tree.calculateHeight());
    }
}
