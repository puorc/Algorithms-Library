/**
 * Created by pu on 2015/8/15/015.
 */
public final class Version implements Comparable<Version> {
    private final int first;
    private final int second;
    private final int third;

    public Version(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
        if ((first < 0) || (second < 0) || (third < 0))
            throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return first + "." + second + "." + third;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == (Version) obj) return true;
        if (this.getClass() == obj.getClass()) {
            if (this.first != ((Version) obj).first) return false;
            if (this.second != ((Version) obj).second) return false;
            if (this.third != ((Version) obj).third) return false;
            return true;
        }
        return false;
    }

    public int compareTo(Version t) {
        int t1 = Integer.parseInt(String.valueOf(first) + String.valueOf(second) + String.valueOf(third));
        int t2 = Integer.parseInt(String.valueOf(t.first) + String.valueOf(t.second) + String.valueOf(t.third));
        if (t1 > t2) return 1;
        else if (t1 == t2) return 0;
        else return -1;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }
}
