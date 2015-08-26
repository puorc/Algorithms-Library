import java.util.NoSuchElementException;

/**
 * Created by pu on 2015/8/26/026.
 */
public class MultiBST<Key extends Comparable<Key>, Value> {
    private BST<Key, Queue<Value>> keys;
    private int N;

    public MultiBST() {
        keys = new BST<>();
    }

    public void put(Key key, Value value) {
        if (keys.contains(key))
            keys.get(key).enqueue(value);
        else {
            keys.put(key, new Queue<>());
            keys.get(key).enqueue(value);
        }
        N++;
    }

    public Value get(Key key) {
        if (keys.get(key) == null) throw new NoSuchElementException();
        int random = StdRandom.uniform(keys.get(key).size());
        int i = 0;
        for (Value j : keys.get(key)) {
            if (i == random) return j;
            i++;
        }
        return null;
    }

    public Iterable<Value> getAll(Key key) {
        return keys.get(key);
    }

    public void delete(Key key) {
        int sum = keys.get(key).size();
        if (!keys.contains(key)) throw new IllegalArgumentException();
        keys.delete(key);
        N -= sum;
    }

    public int size() {
        return N;
    }
}
