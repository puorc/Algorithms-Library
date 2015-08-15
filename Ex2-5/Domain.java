/**
 * Created by pu on 2015/8/15/015.
 */
public class Domain implements Comparable<Domain> {
    private final String first;
    private final String second;
    private final String third;

    public Domain(String s) {
        String[] tmp = s.split("\\.");
        if (tmp.length != 3)
            throw new IllegalArgumentException();
        first = tmp[2];
        second = tmp[1];
        third = tmp[0];
    }

    @Override
    public String toString() {
        return first + "." + second + "." + third;
    }

    public int compareTo(Domain a) {
        String s1 = first + second + third;
        String s2 = a.first + a.second + a.third;
        int c = s1.compareTo(s2);
        if (c != 0)
            return c;
        else
            return s1.length() - s2.length();
    }
}
