import java.util.NoSuchElementException;

/**
 * Created by pu on 2015/8/25/025.
 */
public class HashSTint {
    private int[] keys;
    private int[] vals;
    private boolean[] flags;
    private int N;
    private int M;

    public HashSTint() {
        M = 16;
        N = 0;
        keys = new int[M];
        vals = new int[M];
        flags = new boolean[M];
    }

    public HashSTint(int cap) {
        M = cap;
        N = 0;
        keys = new int[M];
        vals = new int[M];
        flags = new boolean[M];
    }

    private int hash(int key) {
        return Integer.hashCode(key) % M;
    }

    private void resize(int max) {
        HashSTint t = new HashSTint(max);
        for (int i = 0; i < M; i++)
            if (flags[i] != false)
                t.put(keys[i], vals[i]);
        N = t.N;
        M = t.M;
        keys = t.keys;
        vals = t.vals;
        flags = t.flags;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void put(int key, int value) {
        if (N > M / 2) resize(2 * M);
        int i;
        for (i = hash(key); flags[i] != false; i = (i + 1) % M) {
            if (keys[i] == key) {
                vals[i] = value;
                return;
            }
        }
        keys[i] = key;
        vals[i] = value;
        flags[i] = true;
        N++;
    }

    public int get(int key) {
        for (int i = hash(key); flags[i] != false; i = (i + 1) % M)
            if (key == keys[i]) return vals[i];
        throw new NoSuchElementException();
    }

    public boolean contains(int key) {
        for (int i = hash(key); flags[i] != false; i = (i + 1) % M)
            if (key == keys[i]) return true;
        return false;
    }

    public void delete(int key) {
        int i;
        for (i = hash(key); flags[i] != false; i = (i + 1) % M) {
            if (keys[i] == key) {
                flags[i] = false;
                N--;
                break;
            }
        }
        i = (i + 1) % M;
        while (flags[i] != false) {
            flags[i] = false;
            N--;
            put(keys[i], vals[i]);
            i = (i + 1) % M;
        }
        if (N > 0 && N < M / 4) resize(M / 2);
    }

    public Iterable<Integer> keys() {
        Queue<Integer> a = new Queue<>();
        for (int i = 0; i < M; i++)
            if (flags[i] != false)
                a.enqueue(keys[i]);
        return a;
    }
}

