/**
 * Created by pu on 2015/8/20/020.
 */
public class BST_EX<Key extends Comparable<Key>, Value> {
    private node root;

    private class node {
        node left;
        node right;
        Key key;
        Value val;
        int N;

        public node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    private int size(node x) {
        if (x == null) return 0;
        return x.N;
    }

    public int size() {
        return size(root.left);
    }

    public Value get(Key key) {
        node tmp = root;
        while (tmp != null) {
            int cmp = tmp.key.compareTo(key);
            if (cmp == 0) return tmp.val;
            else if (cmp > 0) tmp = tmp.left;
            else tmp = tmp.right;
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (root == null)
            root = new node(key, value, 1);
        node tmp = root;
        node parent = null;
        while (tmp != null) {
            int cmp = tmp.key.compareTo(key);
            if (cmp == 0) {
                tmp.val = value;
                break;
            } else if (cmp > 0) {
                parent = tmp;
                tmp = tmp.left;
            } else {
                parent = tmp;
                tmp = tmp.right;
            }
        }
        if (tmp == null) {
            int cmp = parent.key.compareTo(key);
            if (cmp > 0) parent.left = new node(key, value, 1);
            if (cmp < 0) parent.right = new node(key, value, 1);
            tmp = root;
            while (tmp != null) {
                int acmp = tmp.key.compareTo(key);
                if (acmp == 0) break;
                else if (acmp < 0) {
                    tmp.N++;
                    tmp = tmp.right;
                } else {
                    tmp.N++;
                    tmp = tmp.left;
                }
            }
        }
    }

    public Key min() {
        node tmp = root;
        while (tmp.left != null) {
            tmp = tmp.left;
        }
        return tmp.key;
    }

    public Key max() {
        node tmp = root;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        return tmp.key;
    }

    public Key floor(Key key) {
        node tmp = root;
        Key forMax = null;
        while (tmp != null) {
            int cmp = tmp.key.compareTo(key);
            if (cmp > 0) {
                if (forMax != null && tmp.key.compareTo(forMax) > 0 && tmp.key.compareTo(key) < 0)
                    forMax = tmp.key;
                tmp = tmp.left;
            } else if (cmp == 0) return key;
            else {
                if (tmp.key.compareTo(key) < 0)
                    forMax = tmp.key;
                tmp = tmp.right;
            }
        }
        return forMax;
    }

    public Key select(int k) {
        node tmp = root;
        int counter = k;
        while (tmp != null) {
            if (size(tmp.left) == counter) return tmp.key;
            else if (size(tmp.left) > counter) tmp = tmp.left;
            else {
                counter -= (size(tmp.left) + 1);
                tmp = tmp.right;
            }
        }
        return null;
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
