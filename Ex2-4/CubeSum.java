/**
 * Created by pu on 2015/8/15/015.
 */
public class CubeSum implements Comparable<CubeSum> {
    private final int sum;
    private final int i;
    private final int j;

    public CubeSum(int i, int j) {
        this.sum = i * i * i + j * j * j;
        this.i = i;
        this.j = j;
    }

    public int compareTo(CubeSum that) {
        if (this.sum < that.sum) return -1;
        if (this.sum > that.sum) return +1;
        return 0;
    }

    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        MaxPQ<CubeSum> pq = new MaxPQ<>();
        for (int i = 0; i <= N; i++) {
            pq.insert(new CubeSum(i, i));
        }
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMax();
            StdOut.println(s);
            if (s.j < N) pq.insert(new CubeSum(s.i, s.j + 1));
        }
    }
}

