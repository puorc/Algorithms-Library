/**
 * Created by pu on 2015/7/28.
 */
public class VisualAccmulator {
    private double total;
    private int N;
    public VisualAccmulator(int trials,double max){
        StdDraw.setXscale(0,trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }
    public void add(double val){
        N++;
        total+=val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N,total/N);
    }
    public double avarage(){
        return total/N;
    }
}
