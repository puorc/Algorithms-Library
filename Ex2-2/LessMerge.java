/**
 * Created by pu on 2015/8/8/008.
 */
public class LessMerge {
    private static Comparable[] aux;

    private static boolean lessBlock(Comparable start, Comparable end) {
        return start.compareTo(end) < 0;
    }

    private static void exchBlock(Comparable[] a, int block, int start, int end) {
        if (Math.abs(end - start) % block != 0) throw new IllegalArgumentException();
        Comparable[] tmp = new Comparable[block];
        for (int i = start, j = 0; i < start + block; i++, j++)
            tmp[j] = a[i];
        for (int i = end, j = start; i < end + block; i++, j++)
            a[j] = a[i];
        for (int i = end, j = 0; i < end + block; i++, j++)
            a[i] = tmp[j];
    }

    private static void selectionBlock(Comparable[] a, int block) {
        for (int i = 0; i < a.length / block; i++) {
            Comparable min = a[i * block];
            for (int j = (i + 1) * block; j < a.length; j += block) {
                if (lessBlock(a[j], min)) {
                    min = a[j];
                    exchBlock(a, block, i * block, j);
                }
            }
        }
    }
}
