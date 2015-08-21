/**
 * Created by pu on 2015/8/19/019.
 */
// Ex3.2.23 statement is false.
public class VerifyDel {
    private static Double[] generate(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.random();
        return a;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        for (int i = 0; i < T; i++) {
            Double[] a = generate(N);
            ST<Double, Integer> container0 = new BST<>();
            ST<Double, Integer> container1 = new BST<>();
            for (int j = 0; j < a.length; j++) {
                container0.put(a[j], 0);
                container1.put(a[j], 0);
            }
            container0.delete(a[N / 2]);
            container0.delete(a[N / 3]);
            container1.delete(a[N / 3]);
            container1.delete(a[N / 2]);
            if (!container0.equals(container1)) {
                System.out.println("FALSE!!");
                break;
            }
        }
    }
}
