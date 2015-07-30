/**
 * Created by ZhaoPu on 2015/7/30.
 */
public class Test {
    public static void main(String[] args) {
        Stack<String> a=new Stack<>();
        a.push("pds");
        a.push("sad");
        for(String s : a){
            System.out.println(s);
        }
        System.out.println(a.isEmpty());
        System.out.println(a.size());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.size());
        System.out.println(a.isEmpty());
    }
}
