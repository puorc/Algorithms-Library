/**
 * Created by pu on 2015/8/13/013.
 */
public class isMinHeap {
    public static boolean check(Comparable[] a) {
        return check(a, 1);
    }

    private static boolean check(Comparable[] a, int k) {
        int N = a.length - 1;
        if (k > N) return true;
        int left = 2 * k, right = 2 * k + 1;
        if (left <= N && great(a[k], a[left])) return false;
        if (right <= N && great(a[k], a[right])) return false;
        return check(a, left) && check(a, right);
    }

    private static boolean great(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }
}
