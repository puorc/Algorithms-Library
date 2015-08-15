/**
 * Created by pu on 2015/8/15/015.
 */

import java.util.Comparator;
import java.util.NoSuchElementException;

public class California {
    private static char[] order = {'R', 'W', 'Q', 'O', 'J', 'M', 'V', 'A', 'H', 'B', 'S', 'G', 'Z', 'X', 'N', 'T', 'C', 'I', 'E', 'K', 'U', 'P', 'D', 'Y', 'F', 'L'};

    private static int query(char c) {
        for (int i = 0; i < order.length; i++)
            if (order[i] == c)
                return i;
        throw new NoSuchElementException();
    }

    public static class CaliforniaOrder implements Comparator<String> {
        public int compare(String s1, String s2) {
            char a = s1.charAt(0);
            char b = s2.charAt(0);
            if (query(a) > query(b)) return 1;
            else if (query(a) < query(b)) return -1;
            else return 0;
        }
    }
}
