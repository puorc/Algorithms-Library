/**
 * Created by pu on 2015/8/25/025.
 */
public class Invert {
    public static BST<String, Bag<String>> invert(BST<String, Bag<String>> a) {
        BST<String, Bag<String>> tmp = new BST<>();
        for (String para1 : a.keys()) {
            for (String para2 : a.get(para1)) {
                if (!tmp.contains(para2))
                    tmp.put(para2, new Bag<>());
                tmp.get(para2).add(para1);
            }
        }
        return tmp;
    }
}
