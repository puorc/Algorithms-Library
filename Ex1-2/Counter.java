/**
 * Created by pu on 2015/7/28.
 */
public class Counter {
    private final String name;
    private int count;

    Counter(String id) {
        name = id;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return count + " " + name;
    }
}
