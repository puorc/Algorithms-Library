/**
 * Created by pu on 2015/8/23/023.
 */
public class SeparateChainingHashST<Key, Value> implements ST<Key, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        M = 3;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST<>();
        N = 0;
    }

    private SeparateChainingHashST(int cap) {
        M = cap;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST<>();
        N = 0;
    }

    private void resize(int max) {
        SeparateChainingHashST<Key, Value> tmp = new SeparateChainingHashST<>(max);
        for (Key i : keys())
            tmp.put(i, get(i));
        N = tmp.N;
        M = tmp.M;
        st = tmp.st;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void put(Key key, Value value) {
        int it = st[hash(key)].size();
        st[hash(key)].put(key, value);
        int diff = st[hash(key)].size() - it;
        if (diff != 0)
            N++;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void delete(Key key) {
        int init = st[hash(key)].size();
        st[hash(key)].delete(key);
        int diff = st[hash(key)].size() - init;
        if (diff != 0)
            N--;
        if (N > 0 && N < M / 4) resize(M / 2);
    }

    public boolean contains(Key key) {
        return st[hash(key)].contains(key);
    }

    public Iterable<Key> keys() {
        Queue<Key> tmp = new Queue<>();
        for (int i = 0; i < st.length; i++)
            for (Key m : st[i].keys()) {
                if (m == null) continue;
                tmp.enqueue(m);
            }
        return tmp;
    }
}
