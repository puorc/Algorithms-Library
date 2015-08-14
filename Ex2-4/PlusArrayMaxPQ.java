/**
 * Created by pu on 2015/8/14/014.
 */
public class PlusArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public PlusArrayMaxPQ(int Max) {
        pq = (Key[]) new Comparable[Max];
    }

    public PlusArrayMaxPQ(Key[] a) {
        pq = (Key[]) new Comparable[a.length];
        for (Key i : a)
            insert(i);
    }

    public void insert(Key key) {
        pq[N++] = key;
        Quick.sort(pq, 0, N - 1);
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Key max() {
        return pq[N - 1];
    }

    public Key delMax() {
        Key max = pq[N - 1];
        N--;
        return max;
    }
}
