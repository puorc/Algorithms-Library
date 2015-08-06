/**
 * Created by pu on 2015/8/5/005.
 */
public class GuardInsertion extends Example {
    public void sort(Comparable[] a) {
        Comparable min = a[0];
        int position = 0;
        for (int j = 1; j < a.length; j++) {
            if (less(a[j], min)) {
                position = j;
                min = a[j];
            }
        }
        a[position] = a[0];
        a[0] = min;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; less(a[j + 1], a[j]); j--) {
                exch(a, j, j + 1);
            }
        }
    }
}