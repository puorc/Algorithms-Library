/**
 * Created by ZhaoPu on 2015/7/30.
 */
public class test {
    public static void main(String[] args) {
        Queue<String> a=new Queue<>();
        a.enqueue("a");
        a.enqueue("b");
        a.enqueue("c");
        System.out.println(a.isEmpty());
        System.out.println(a.size());
        System.out.println(a.dequeue());
        System.out.println(a.size());
        Queue<String> b=new Queue<>(a);
        for(String s : b)
            System.out.println(s);
    }
}
