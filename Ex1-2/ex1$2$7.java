/**
 * Created by pu on 2015/7/28.
 */
// print the string in reverse order.
public class ex1$2$7 {
    public static String mystery(String s){
        int N=s.length();
        if(N<=1)
            return s;
        String a=s.substring(0,N/2);
        String b=s.substring(N/2,N);
        return mystery(b)+mystery(a);
    }
    public static void main(String[] args) {
        System.out.println(mystery(args[0]));
    }
}


