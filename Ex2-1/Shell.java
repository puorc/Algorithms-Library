/**
 * Created by pu on 2015/8/5/005.
 */
public class Shell extends Example {
    public void sort(Comparable[] a){
        int N=a.length;
        int h=1;
        while(h<N/3) h=3*h+1;
        for(int i=h;i>=1;i=i/3){
            for(int j=i;j<N;j++){
                for(int k=j;k>=i&&less(a[k],a[k-i]);k-=i) {
                    exch(a, k, k - i);
                }
            }
        }
    }
}
