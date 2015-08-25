/**
 * Created by pu on 2015/8/25/025.
 */
public class ex3$5$24 {
    public static int InInterval(Integer[] interval, Integer key) {
        if (interval.length % 2 != 0) throw new IllegalArgumentException();
        BST<Integer, Integer> upper = new BST<>();
        BST<Integer, Integer> lower = new BST<>();
        for (int i = 0, j = 1; i < interval.length - 1; i += 2, j++) {
            lower.put(interval[i], j);
            upper.put(interval[i + 1], j);
        }
        int lkey = lower.get(lower.floor(key));
        int ukey = upper.get(upper.ceiling(key));
        if (lkey == ukey)
            return lkey;
        return -1;
    }
}
