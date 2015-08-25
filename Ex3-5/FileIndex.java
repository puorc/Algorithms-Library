import java.io.File;

/**
 * Created by pu on 2015/8/25/025.
 */
public class FileIndex {
    public static void main(String[] args) {
        RedBlackBST<String, Bag<File>> st = new RedBlackBST<>();
        for (String filename : args) {
            File file = new File(filename);
            In in = new In(file);
            while (!in.isEmpty()) {
                String word = in.readString();
                if (st.get(word) == null) st.put(word, new Bag<>());
                st.get(word).add(file);
            }
        }
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.get(query) != null)
                for (File file : st.get(query))
                    System.out.print(" " + file.getName());
        }
    }
}
