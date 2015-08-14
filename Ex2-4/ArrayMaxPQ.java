/**
 * Created by pu on 2015/8/14/014.
 */
public class ArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public ArrayMaxPQ(int Max) {
        pq = (Key[]) new Comparable[Max];
    }

    public ArrayMaxPQ(Key[] a) {
        pq = (Key[]) new Comparable[a.length];
        for (Key i : a)
            insert(i);
    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void insert(Key key) {
        pq[N++] = key;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Key max() {
        Key max = pq[0];
        for (int i = 1; i < N; i++) {
            if (less(max, pq[i]))
                max = pq[i];
        }
        return max;
    }

    public Key delMax() {
        Key max = pq[0];
        int position = 0;
        for (int i = 1; i < N; i++) {
            if (less(max, pq[i])) {
                position = i;
                max = pq[i];
            }
        }
        exch(pq, N - 1, position);
        N--;
        return max;
    }
}
