/**
 * Created by pu on 2015/7/28.
 */
public class TestVA {
    public static void main(String[] args) {
        int T=10;
        VisualAccmulator a=new VisualAccmulator(T,1.0);
        for(int i=0;i<T;i++){
            a.add(StdRandom.random());
        }
    }
}
