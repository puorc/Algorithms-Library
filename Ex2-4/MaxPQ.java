/**
 * Created by pu on 2015/8/13/013.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    public MaxPQ(Key[] a) {
        pq = (Key[]) new Comparable[a.length + 1];
        for (Key i : a)
            insert(i);
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

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key max() {
        return pq[1];
    }

    public Key delMax() {
        Key max = pq[1];
        exch(pq, 1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
}
