/**
 * Created by pu on 2015/8/15/015.
 */
public class SearchMedian {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] keys, int i, int j) {
        Comparable tmp = keys[i];
        keys[i] = keys[j];
        keys[j] = tmp;
    }

    private static int partition(Comparable[] keys, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(keys[++i], keys[lo])) if (i == hi) break;
            while (less(keys[lo], keys[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(keys, i, j);
        }
        exch(keys, j, lo);
        return j;
    }

    public static Comparable selection(Comparable[] keys) {
        int k = keys.length / 2, lo = 0, hi = keys.length - 1;
        while (lo < hi) {
            int j = partition(keys, lo, hi);
            if (j == k) break;
            else if (j > k) hi = j - 1;
            else lo = j + 1;
        }
        return keys[k];
    }
}
