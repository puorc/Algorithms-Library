/**
 * Created by pu on 2015/8/15/015.
 */
public class Dedup {
    public static String[] dedup(String[] a) {
        Quick.sort(a);
        Queue<String> tmp = new Queue<>();
        String key = a[0];
        tmp.enqueue(key);
        for (int i = 1; i < a.length; i++) {
            if (a[i] != key) {
                key = a[i];
                tmp.enqueue(key);
            }
        }
        String[] result = new String[tmp.size()];
        int index = 0;
        for (String i : tmp)
            result[index++] = i;
        return result;
    }
}
