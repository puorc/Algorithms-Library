/**
 * Created by pu on 2015/8/4/004.
 */
public class Selection extends Example {
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            Comparable min = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], min)) {
                    min = a[j];
                    exch(a, i, j);
                }
            }
        }
    }
}
