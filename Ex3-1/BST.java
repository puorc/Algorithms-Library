import java.util.NoSuchElementException;

/**
 * Created by pu on 2015/8/18/018.
 */
public class BST<Key extends Comparable, Value> implements ST<Key, Value> {
    private node root;
    private node cache;

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
        else {
            cache = x;
            return x.val;
        }
    }

    public Value get(Key key) {
        if (cache != null && key.compareTo(cache.key) == 0)
            return cache.val;
        return get(root, key);
    }

    private node put(node x, Key key, Value value) {
        if (x == null) return new node(key, value);
        int cmp = x.key.compareTo(key);
        if (cmp > 0) x.left = put(x.left, key, value);
        else if (cmp < 0) x.right = put(x.right, key, value);
        else {
            x.val = value;
            cache = x;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void put(Key key, Value value) {
        if (cache != null && key.compareTo(cache.key) == 0)
            cache.val = value;
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

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> a = new Queue<>();
        keys(a, root, lo, hi);
        return a;
    }

    private void keys(Queue a, node x, Key lo, Key hi) {
        if (x == null) return;
        int cmpl = x.key.compareTo(lo);
        int cmph = x.key.compareTo(hi);
        if (cmpl > 0) keys(a, x.left, lo, hi);
        if (cmpl >= 0 && cmph <= 0) a.enqueue(x.key);
        if (cmph < 0) keys(a, x.right, lo, hi);
    }

    private Key min(node x) {
        if (x.left == null) return x.key;
        return min(x.left);
    }

    public Key min() {
        return min(root);
    }

    private node findMin(node x) {
        if (x.left == null) return x;
        return findMin(x.left);
    }

    private Key max(node x) {
        if (x.right == null) return x.key;
        return max(x.right);
    }

    public Key max() {
        return max(root);
    }

    private Key floor(node x, Key key) {
        if (x == null) return null;
        int cmp = x.key.compareTo(key);
        if (cmp == 0) return x.key;
        else if (cmp > 0) return floor(x.left, key);
        else {
            Key tmp = floor(x.right, key);
            if (tmp == null) return x.key;
            return tmp;
        }

    }

    public Key floor(Key key) {
        return floor(root, key);
    }

    private Key ceiling(node x, Key key) {
        if (x == null) return null;
        int cmp = x.key.compareTo(key);
        if (cmp == 0) return x.key;
        else if (cmp < 0) return ceiling(x.right, key);
        else {
            Key tmp = ceiling(x.left, key);
            if (tmp == null) return x.key;
            return tmp;
        }
    }

    public Key ceiling(Key key) {
        return ceiling(root, key);
    }

    private node select(node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t == k) return x;
        if (t > k) return select(x.left, k);
        else {
            return select(x.right, k - t - 1);
        }
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private int rank(node x, Key key) {
        if (x == null) throw new NoSuchElementException();
        int cmp = x.key.compareTo(key);
        if (cmp == 0) return size(x.left);
        else if (cmp < 0) return rank(x.right, key) + size(x.left) + 1;
        else return rank(x.left, key);
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private node deleteMin(node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private node deleteMax(node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private node delete(node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) x.right = delete(x.right, key);
        else if (cmp < 0) x.left = delete(x.left, key);
        else {
            if (x.left == null) return x.right;
            else if (x.right == null) return x.left;
            else {
                node t = x;
                x = findMin(x.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private int height(node x) {
        if (x == null) return 0;
        int left = height(x.left);
        int right = height(x.right);
        return Math.max(left, right) + 1;
    }

    public int height() {
        return height(root);
    }

    private Key randomKey(node x) {
        int cmp = StdRandom.uniform(10);
        if (cmp % 2 == 0) {
            if (x.left != null)
                return randomKey(x.left);
        } else {
            if (x.right != null)
                return randomKey(x.right);
        }
        return x.key;
    }

    public Key randomKey() {
        return randomKey(root);
    }
}
