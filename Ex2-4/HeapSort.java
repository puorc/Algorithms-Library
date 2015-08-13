/**
 * Created by pu on 2015/8/13/013.
 */
public class HeapSort {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * To make the array sorted.
     *
     * @param a is the target array.
     * @param k is the initial node.
     * @param N is the size of the heap. (N is the number rather than index.)
     */
    private static void sink(Comparable[] a, int k, int N) {
        int j;
        while (2 * k + 1 <= N - 1) {
            j = 2 * k + 1;
            if ((j + 1 <= N - 1) && less(a[j], a[j + 1])) j++;
            if (!less(a[k], a[j])) break;
            exch(a, k, j);
            k = j;
        }
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        N = (N - 1 - 1) / 2;
        for (int i = N; i >= 0; i--)
            sink(a, i, a.length);
        for (int j = a.length; j >= 1; j--) {
            exch(a, 0, j - 1);
            sink(a, 0, j - 1);
        }
    }
}
