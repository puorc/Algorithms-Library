/**
 * Created by pu on 2015/8/4/004.
 */
public abstract class Example {
    public abstract void sort(Comparable[] a);
    protected boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
    protected void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    public void show(Comparable[] a){
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }
    public boolean isSorted(Comparable[] a){
        for(int i=0;i<a.length-1;i++)
            if(less(a[i+1],a[i])) return false;
        return true;
    }
}
