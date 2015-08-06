/**
 * Created by pu on 2015/8/5/005.
 */
public class Insertion extends Example {
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j >= 0 && less(a[j + 1], a[j]); j--) {
                exch(a, j, j + 1);
            }
        }
    }
}
