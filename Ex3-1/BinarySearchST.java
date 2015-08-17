import java.util.NoSuchElementException;

/**
 * Created by pu on 2015/8/17/017.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    private Key[] key;
    private Value[] val;
    private int N;

    public BinarySearchST(int capacity) {
        key = (Key[]) new Comparable[capacity];
        val = (Value[]) new Comparable[capacity];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private int rank(Key key, int lo, int hi) {
        if (lo > hi) return lo;
        int mid = (lo + hi) / 2;
        int cmp = key.compareTo(this.key[mid]);
        if (cmp < 0) return rank(key, lo, mid - 1);
        else if (cmp > 0) return rank(key, mid + 1, hi);
        else return mid;
    }

    public int rank(Key key) {
        return rank(key, 0, N - 1);
    }

    public Value get(Key key) {
        int location = rank(key, 0, N - 1);
        if (location < N && this.key[location].compareTo(key) == 0) return val[location];
        throw new NoSuchElementException();
    }

    public void put(Key key, Value value) {
        int location = rank(key, 0, N - 1);
        if (location < N && this.key[location].compareTo(key) == 0) val[location] = value;
        else {
            for (int i = N; i > location; i--) {
                this.key[i] = this.key[i - 1];
                val[i] = val[i - 1];
            }
            this.key[location] = key;
            val[location] = value;
            N++;
        }
    }

    public void delete(Key key) {
        int location = rank(key, 0, N - 1);
        if (location < N && this.key[location].compareTo(key) == 0) {
            for (int i = location; i < N - 1; i++) {
                this.key[i] = this.key[i + 1];
                val[i] = val[i + 1];
            }
            N--;
            return;
        }
        throw new NoSuchElementException();
    }

    public Key min() {
        return key[0];
    }

    public Key max() {
        return key[N - 1];
    }

    public Key select(int k) {
        return key[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key, 0, N - 1);
        return this.key[i];
    }

    public Key floor(Key key) {
        if (rank(key) == 0)
            return this.key[0];
        int i = rank(key) - 1;
        return this.key[i];
    }

    public boolean contains(Key key) {
        int location = rank(key, 0, N - 1);
        if (location < N && this.key[location].compareTo(key) == 0)
            return true;
        return false;
    }

    public Iterable<Key> keys() {
        Queue<Key> container = new Queue<>();
        for (int i = 0; i < N; i++)
            container.enqueue(key[i]);
        return container;
    }
}
