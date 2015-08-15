/**
 * Created by pu on 2015/8/15/015.
 */
public class IndexMaxPQ<Key extends Comparable<Key>> {
    private Integer[] pq;
    private Integer[] qp;
    private Key[] keys;
    private int N = 0;

    public IndexMaxPQ(int max) {
        pq = new Integer[max + 1];
        qp = new Integer[max + 1];
        keys = (Key[]) new Comparable[max + 1];
        for (int i = 0; i < qp.length; i++)
            qp[i] = -1;
    }

    private void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private void swim(int k) {
        while (k / 2 >= 1 && (less(pq[k / 2], pq[k]))) {
            exch(pq, k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        int j = 0;
        while (2 * k <= N) {
            j = 2 * k;
            if ((j + 1 <= N) && less(pq[j], pq[j + 1])) j++;
            if (!less(pq[k], pq[j])) break;
            exch(pq, k, j);
            k = j;
        }
    }

    public void insert(int k, Key key) {
        keys[k] = key;
        pq[++N] = k;
        qp[k] = N;
        swim(N);
    }

    public Key max() {
        return keys[pq[1]];
    }

    public Key delMax() {
        Key max = keys[pq[1]];
        keys[pq[1]] = null;
        qp[pq[1]] = -1;
        exch(pq, 1, N--);
        sink(1);
        return max;
    }

    public void change(int k, Key key) {
        keys[k] = key;
    }

    public void delete(int k) {
        keys[k] = null;
        exch(pq, qp[k], N--);
        swim(qp[k]);
        sink(qp[k]);
        qp[k] = -1;
    }

    public int minIndex() {
        return pq[1];
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
}
