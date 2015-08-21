import java.util.NoSuchElementException;

/**
 * Created by pu on 2015/8/21/021.
 */
public class RedBlackBST<Key extends Comparable, Value> {
    private final boolean BLACK = false;
    private final boolean RED = true;
    private node root;

    private class node {
        node left;
        node right;
        Key key;
        Value value;
        int N;
        boolean color;

        public node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    private int size(node x) {
        if (x == null) return 0;
        return x.N;
    }

    public int size() {
        return size(root);
    }

    private boolean isRed(node x) {
        if (x == null) return false;
        if (x.color == RED) return true;
        return false;
    }

    private node rotateLeft(node x) {
        node h = x.right;
        x.right = h.left;
        h.left = x;
        h.color = x.color;
        x.color = RED;
        h.N = x.N;
        x.N = size(x.left) + size(x.right) + 1;
        return h;
    }

    private node rotateRight(node x) {
        node h = x.left;
        x.left = h.right;
        h.right = x;
        h.color = x.color;
        x.color = RED;
        h.N = x.N;
        x.N = size(x.left) + size(x.right) + 1;
        return h;
    }

    private void flipColors(node x) {
        x.left.color = BLACK;
        x.right.color = BLACK;
        x.color = RED;
    }

    private node put(node x, Key key, Value value) {
        if (x == null) return new node(key, value, 1, RED);
        int cmp = x.key.compareTo(key);
        if (cmp < 0) x.right = put(x.right, key, value);
        else if (cmp > 0) x.left = put(x.left, key, value);
        else
            x.value = value;
        if (!isRed(x.left) && isRed(x.right)) x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right)) flipColors(x);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    public Value get(Key key) {
        node tmp = root;
        while (tmp != null) {
            int cmp = tmp.key.compareTo(key);
            if (cmp == 0) return tmp.value;
            else if (cmp > 0) tmp = tmp.left;
            else tmp = tmp.right;
        }
        return null;
    }

    private Key min(node x) {
        if (x.left == null) return x.key;
        return min(x.left);
    }

    public Key min() {
        return min(root);
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

    private int height(node x) {
        if (x == null) return 0;
        int left = height(x.left);
        int right = height(x.right);
        return Math.max(left, right) + 1;
    }

    public int height() {
        return height(root);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private boolean isAllElementNull(Queue<node> a) {
        for (node c : a)
            if (c != null)
                return false;
        return true;
    }

    private void printLevel(Queue<node> nodes, int level, int maxLevel) {
        if (isAllElementNull(nodes)) return;
        int floor = maxLevel - level;
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
        printWhitespaces(firstSpaces);
        Queue<node> newnodes = new Queue<>();
        for (node element : nodes) {
            if (element != null) {
                System.out.print(element.key);
                newnodes.enqueue(element.left);
                newnodes.enqueue(element.right);
            } else {
                System.out.print(" ");
                newnodes.enqueue(null);
                newnodes.enqueue(null);
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println("");
        printLevel(newnodes, level + 1, maxLevel);
    }

    public void printLevel() {
        Queue<node> nodes = new Queue<>();
        nodes.enqueue(root);
        printLevel(nodes, 1, height());
    }
}
