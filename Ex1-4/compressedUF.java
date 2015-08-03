/**
 * Created by pu on 2015/8/3/003.
 */
public class compressedUF extends UF{
    compressedUF(int N) { super(N); }
    public int find(int p){
        int q=p;
        while(id[q]!=q) q=id[q];
        while(id[p]!=p){
            id[p]=q;
            p=id[p];
        }
        return q;
    }
}
