/**
 * Created by pu on 2015/8/3/003.
 */
public class UF {
    protected int count;
    protected int id[];
    protected int sz[];

    public UF() {
    }

    public UF(int N) {
        count = 1;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        count = N;
    }

    public int find(int p) {
        while (id[p] != p) p = id[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        if (!connected(p, q)) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (sz[pRoot] > sz[qRoot]) {
                id[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            } else {
                id[pRoot] = qRoot;
                sz[qRoot] += sz[pRoot];
            }
            count--;
        }
    }

    public int count() {
        return count;
    }
}
