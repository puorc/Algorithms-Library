/**
 * Created by pu on 2015/8/5/005.
 */
public class SortCompare {
    public static double time(String alg,Double[] a){
        Stopwatch timer=new Stopwatch();
        if(alg.equals("Insertion")){
            Insertion e=new Insertion();
            e.sort(a);
        }
        if(alg.equals("Selection")){
            Selection b=new Selection();
            b.sort(a);
        }
        if(alg.equals("Shell")){
            Shell c=new Shell();
            c.sort(a);
        }
        return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg,int N,int T){
        double total=0.0;
        Double[] a=new Double[N];
        for(int i=0;i<T;i++){
            for(int j=0;j<N;j++)
                a[j]=StdRandom.uniform();
            total+=time(alg,a);
        }
        return total;
    }
    public static void main(String[] args) {
        String alg1=args[0];
        String alg2=args[1];
        int N=Integer.parseInt(args[2]);
        int T=Integer.parseInt(args[3]);
        double t1=timeRandomInput(alg1, N, T);
        double t2=timeRandomInput(alg2,N,T);
        System.out.println(alg1+" "+t2/t1+" "+alg2);
    }
}
