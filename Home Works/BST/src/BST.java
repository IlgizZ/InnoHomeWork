/**
 * Created by Ilgiz on 01.11.2016.
 */
public class BST<K extends Comparable, V> {
    private class Node {
        Node left;
        Node right;
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private Node root;

    private int height(Node node) {
        Node left = node.left;
        Node right = node.right;
        int lHeight = 0;
        int rHeight = 0;

        if (left == null && right == null)
            return 1;

        if (left != null)
            lHeight = height(left);
        if (right != null)
            rHeight = height(right);

        return 1 + Math.max(lHeight, rHeight);
    }

    private void print(Node node) {
        if (node == null)
            return;

        if (node.left != null)
            print(node.left);

        System.out.print("(" + node.key + "; " + node.value + ")  ");

        if (node.right != null)
            print(node.right);
    }

    private void insert(Node parent, Node newNode) {
        int comp = parent.key.compareTo(newNode.key);

        if (comp >= 0)
            if (parent.right == null)
                parent.right = newNode;
            else
                insert(parent.right, newNode);
        else if (parent.left == null)
            parent.left = newNode;
        else
            insert(parent.left, newNode);
    }

    private V search(K key, Node node) {

        if (node == null)
            return null;

        if (node.key.equals(key))
            return node.value;

        V result = null;

        if (node.left != null)
            result = search(key, node.left);

        if (result == null && node.right != null)
            result = search(key, node.right);

        return result;
    }

    public int calculateHeight() {
        return root == null ? 0 : height(root);
    }

    public void printContent() {
        print(root);
        System.out.println();
    }

    public void insert(K key, V value) {
        Node newNode = new Node(key, value);

        if (root == null)
            root = newNode;
        else
            insert(root, newNode);
    }

    public V search(K key) {
        return search(key, root);
    }
}
