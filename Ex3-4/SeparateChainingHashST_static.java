/**
 * Created by pu on 2015/8/23/023.
 */
public class SeparateChainingHashST_static<Key, Value> implements ST<Key, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST_static() {
        M = 101;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < st.length; i++)
            st[i] = new SequentialSearchST<>();
        N = 0;
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


