/**
 * Created by pu on 2015/8/24/024.
 */
public class Cuckoo<Key, Value> {
    private LinearProbingHashST<Key, Value> a;
    private LinearProbingHashST<Key, Value> b;

    public Cuckoo() {
        a = new LinearProbingHashST<>(11);
        b = new LinearProbingHashST<>(17);
    }

    public void put(Key key, Value val) {
        System.out.println(key);
        if (key.equals(a.theSameIndex(key))) {
            a.put(key, val);
            return;
        }
        if (key.equals(b.theSameIndex(key))) {
            b.put(key, val);
            return;
        }
        if (a.theSameIndex(key) != null) {
            if (b.theSameIndex(a.theSameIndex(key)) != null) {
                a.put(b.theSameIndex(a.theSameIndex(key)), b.get(b.theSameIndex(a.theSameIndex(key))));
                b.delete(b.theSameIndex(a.theSameIndex(key)));
            }
            b.put(a.theSameIndex(key), a.get(a.theSameIndex(key)));
            a.delete(a.theSameIndex(key));
        }
        a.put(key, val);
    }

    public Value get(Key key) {
        if (a.contains(key))
            return a.get(key);
        if (b.contains(key))
            return b.get(key);
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        Queue<Key> fora = new Queue<>();
        Queue<Key> forb = new Queue<>();
        for (Key i : a.keys())
            fora.enqueue(i);
        for (Key i : b.keys())
            forb.enqueue(i);
        fora.concat(forb);
        return fora;
    }
}
