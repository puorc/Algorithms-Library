/**
 * Created by pu on 2015/8/18/018.
 */
public class BST<Key extends Comparable, Value> implements ST<Key, Value> {
    private node root;

    private class node {
        Key key;
        Value val;
        node left;
        node right;
        int N;

        public node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.N = 1;
        }
    }

    private int size(node root) {
        if (root == null) return 0;
        return root.N;
    }

    public int size() {
        return size(root);
    }

    private Value get(node x, Key key) {
        if (x == null) return null;
        int cmp = x.key.compareTo(key);
        if (cmp > 0) return get(x.left, key);
        else if (cmp < 0) return get(x.right, key);
        else return x.val;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private node put(node x, Key key, Value value) {
        if (x == null) return new node(key, value);
        int cmp = x.key.compareTo(key);
        if (cmp > 0) x.left = put(x.left, key, value);
        else if (cmp < 0) x.right = put(x.right, key, value);
        else x.val = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return contains(root, key);
    }

    private boolean contains(node x, Key key) {
        if (x == null) return false;
        int cmp = x.key.compareTo(key);
        if (cmp > 0) return contains(x.left, key);
        else if (cmp < 0) return contains(x.right, key);
        else return true;
    }

    private void traverse(Queue a, node x) {
        if (x == null) return;
        traverse(a, x.left);
        a.enqueue(x.key);
        traverse(a, x.right);
    }

    public Iterable<Key> keys() {
        Queue<Key> a = new Queue<>();
        traverse(a, root);
        return a;
    }
}
