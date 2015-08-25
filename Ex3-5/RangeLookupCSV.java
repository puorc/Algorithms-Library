/**
 * Created by pu on 2015/8/25/025.
 */
public class RangeLookupCSV {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);
        BST<String, String> st = new BST<>();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key, val);
        }
        String upper = args[4];
        String lower = args[3];
        for (String i : st.keys(lower, upper))
            System.out.print(i + " ");

    }
}
