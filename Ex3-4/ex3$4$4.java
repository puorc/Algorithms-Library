import java.util.Arrays;

/**
 * Created by pu on 2015/8/24/024.
 */
public class ex3$4$4 {
    private static int[] sz = new int[10];

    private static boolean isDifferent() {
        Arrays.sort(sz);
        for (int i = 0; i < sz.length - 1; i++)
            if (sz[i] == sz[i + 1])
                return false;
        return true;
    }

    private static int hash(int a, int M, int k) {
        return (a * k) % M;
    }

    public static void main(String[] args) {
        int a, M;
        for (a = 2; a < 10000; a++) {
            for (M = 2; M <= 10000; M++) {
                for (int i = 0; i < 10; i++)
                    sz[i] = hash(a, M, i + 1);
                if (isDifferent() && M != 11) {
                    System.out.println(a + " " + M);
                    for (int i : sz)
                        System.out.print(i + " ");
                    return;
                }
            }
        }
    }
}
