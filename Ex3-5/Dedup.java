/**
 * Created by pu on 2015/8/24/024.
 */
public class Dedup {
    public static void main(String[] args) {
        RedBlackBST<String, Integer> set = new RedBlackBST<>();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (set.get(key) == null) {
                set.put(key, 0);
                StdOut.print(key + " ");
            }
        }
    }
}
