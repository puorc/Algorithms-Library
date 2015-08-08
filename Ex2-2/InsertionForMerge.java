/**
 * Created by pu on 2015/8/7/007.
 */
public class InsertionForMerge {
    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi - 1; i++) {
            for (int j = i; j >= 0 && less(a[j + 1], a[j]); j--) {
                exch(a, j, j + 1);
            }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++)
            if (less(a[i + 1], a[i])) return false;
        return true;
    }
}
