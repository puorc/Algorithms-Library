/**
 * Created by pu on 2015/8/23/023.
 */
public class LinearProbingHashST<Key, Value> implements ST<Key, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;
    private int M;

    public LinearProbingHashST() {
        M = 16;
        N = 0;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private LinearProbingHashST(int cap) {
        M = cap;
        N = 0;
        keys = (Key[]) new Object[cap];
        vals = (Value[]) new Object[cap];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int max) {
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(max);
        for (int i = 0; i < M; i++)
            if (keys[i] != null && vals[i] != null)
                t.put(keys[i], vals[i]);
        N = t.N;
        M = t.M;
        keys = t.keys;
        vals = t.vals;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        if (N > M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                if (vals[i] == null)
                    N++;
                vals[i] = value;
                return;
            }
        }
        keys[i] = key;
        vals[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (key.equals(keys[i])) return vals[i];
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                keys[i] = null;
                vals[i] = null;
                N--;
            }
        }
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key tmpKey = keys[i];
            Value tmpVal = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(tmpKey, tmpVal);
            i = (i + 1) % M;
        }
        if (N > 0 && N < M / 4) resize(M / 2);
    }

    public void deleteLater(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) {
                vals[i] = null;
                N--;
            }
    }

    public Iterable<Key> keys() {
        Queue<Key> a = new Queue<>();
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                a.enqueue(keys[i]);
        return a;
    }
}
