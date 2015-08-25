/**
 * Created by pu on 2015/8/24/024.
 */
public class LookupIndex {
    public static void main(String[] args) {
        In in = new In(args[0]);
        String sp = args[1];
        RedBlackBST<String, Queue<String>> st = new RedBlackBST<>();
        RedBlackBST<String, Queue<String>> ts = new RedBlackBST<>();
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            String key = a[0];
            for (int i = 1; i < a.length; i++) {
                String val = a[i];
                if (st.get(key) == null) st.put(key, new Queue<>());
                if (ts.get(val) == null) ts.put(val, new Queue<>());
                st.get(key).enqueue(val);
                ts.get(val).enqueue(key);
            }
        }
        String query = args[2];
        if (st.get(query) != null)
            for (String s : st.get(query))
                StdOut.print(" " + s);
        if (ts.get(query) != null)
            for (String s : ts.get(query))
                StdOut.print(" " + s);
    }
}
