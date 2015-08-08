/**
 * Created by pu on 2015/8/7/007.
 */
public class Quick {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable test = a[i];
        a[i] = a[j];
        a[j] = test;
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[lo], a[--j])) if (j <= lo) break;
            while (less(a[++i], a[lo])) if (i >= hi) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        sort(a, 0, N - 1);
    }
}
