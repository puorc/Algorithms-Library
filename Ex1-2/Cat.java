/**
 * Created by pu on 2015/7/28.
 */
public class Cat {
    public static void main(String[] args) {
        Out out=new Out();
        for(int i=0;i<args.length-1;i++){
            In in=new In(args[i]);
            String s=in.readAll();
            out.println(s);
            in.close();
        }

        out.close();
    }
}
