/**
 * Created by pu on 2015/8/7/007.
 */
public class MergeBU {
    private static Comparable[] aux;

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        if (lo >= hi) return;
        for (int i = lo; i <= hi; i++)
            aux[i] = a[i];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    //  Fucking loop conditions!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //  2 hours!!!!!!!!!!!!!!!!!!!!!!
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        for (int sz = 1; sz < a.length; sz += sz) {
            for (int k = 0; k < a.length - sz; k += (2 * sz))
                merge(a, k, k + sz - 1, Math.min(k + sz + sz - 1, a.length - 1));
        }
    }
}
