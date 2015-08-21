/**
 * Created by pu on 2015/8/17/017.
 */
public class cc {
    public static void main(String[] args) {
        BST_EX<Integer,Integer> a=new BST_EX<>();
        a.put(2,2);
        a.put(9,4);
        a.put(5,6);
        a.put(4,8);
        a.put(1,1);
        a.put(2,6);
        a.put(0,0);
        System.out.println(a.select(0));
        a.printLevel();
    }
}
