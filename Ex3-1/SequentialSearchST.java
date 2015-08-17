import java.util.NoSuchElementException;

/**
 * Created by pu on 2015/8/17/017.
 */
public class SequentialSearchST<Key, Value> implements ST<Key, Value> {
    private node first;
    private int N;

    private class node {
        Key key;
        Value val;
        node next;

        public node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private node getNode(Key key) {
        node tmp = first;
        while (tmp != null) {
            if (tmp.key.equals(key)) return tmp;
            tmp = tmp.next;
        }
        return null;
    }

    public boolean contains(Key key) {
        if (getNode(key) != null)
            return true;
        else
            return false;
    }

    public void put(Key key, Value value) {
        if (value == null) {
            delete(key);
            N--;
            return;
        } else if (getNode(key) != null) {
            node tmp = getNode(key);
            tmp.val = value;
            return;
        } else {
            node another = new node(key, value);
            another.next = first;
            first = another;
            N++;
        }
    }

    public Value get(Key key) {
        if (getNode(key) == null)
            throw new NoSuchElementException();
        else
            return getNode(key).val;
    }

    public void delete(Key key) {
        node tmp = first;
        if (tmp.key.equals(key)) {
            first = null;
            return;
        }
        while (tmp.next != null) {
            if (tmp.next.key.equals(key)) {
                tmp.next = tmp.next.next;
                N--;
                return;
            }
            tmp = tmp.next;
        }
        throw new NoSuchElementException();
    }

    public Iterable<Key> keys() {
        Queue<Key> a = new Queue<>();
        node tmp = first;
        while (tmp != null) {
            a.enqueue(tmp.key);
            tmp = tmp.next;
        }
        return a;
    }
}
