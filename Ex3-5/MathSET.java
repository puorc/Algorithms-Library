import java.util.Arrays;

/**
 * Created by pu on 2015/8/25/025.
 */
public class MathSET<Key extends Comparable> {
    private Key[] universe;
    private BST<Key, Integer> keys;

    public MathSET(Key[] universe) {
        this.universe = universe;
        Quick.sort(universe);
        keys = new BST<>();
    }

    public void add(Key key) {
        if (Arrays.binarySearch(universe, key) != -1)
            keys.put(key, 1);
    }

    public int size() {
        return keys.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return keys.contains(key);
    }

    public void delete(Key key) {
        keys.delete(key);
    }

    public MathSET<Key> complement() {
        MathSET<Key> acomplement = new MathSET<>(universe);
        for (Key i : universe)
            if (!keys.contains(i))
                acomplement.add(i);
        return acomplement;
    }

    public Iterable<Key> keys() {
        return keys.keys();
    }

    public void union(MathSET<Key> a) {
        for (Key i : a.keys())
            keys.put(i, 1);
    }

    public void intersection(MathSET<Key> a) {
        for (Key i : keys.keys())
            if (!a.contains(i))
                delete(i);
    }
}
