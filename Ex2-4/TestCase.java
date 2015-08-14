/**
 * Created by pu on 2015/8/14/014.
 */
public class TestCase {
    public static boolean test(int N, int upper) {
        Double[] data = new Double[N];
        for (int i = 0; i < data.length; i++) {
            data[i] = (double) StdRandom.uniform(upper);
        }
        MaxPQ<Double> a = new MaxPQ<>(data, 2 * N);
        MaxPQ<Double> b = new MaxPQ<>(data, 2 * N);
        a.insert(a.max() + 1);
        a.insert(a.max() + 2);
        a.delMax();
        a.delMax();
        for (int i = 0; i < a.size(); i++)
            if (a.delMax() != b.delMax()) return false;
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if (!test(100, 50000))
                System.out.println("Failed!!");
        }
    }
}
