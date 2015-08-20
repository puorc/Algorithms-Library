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
}
