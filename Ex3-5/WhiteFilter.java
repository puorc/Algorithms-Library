/**
 * Created by pu on 2015/8/24/024.
 */
public class WhiteFilter {
    public static void main(String[] args) {
        RedBlackBST<String, Integer> set = new RedBlackBST<>();
        In in = new In(args[0]);
        while (!in.isEmpty())
            set.put(in.readString(), 0);
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (set.get(word) != null)
                System.out.print(word + " ");
        }
    }
}
