/**
 * Created by ZhaoPu on 2015/8/1.
 */
import java.util.UnknownFormatConversionException;
public class Josephus {
    private final int people;
    private final int count;
    private boolean[] state;

    public Josephus(int m, int n) {
        if (n <= 1) throw new UnknownFormatConversionException("N is invalid");
        people = m;
        count = n;
        state = new boolean[m];
    }

    private boolean isAllDead() {
        for (boolean flag : state)
            if (flag == false)
                return false;
        return true;
    }

    public void solve() {
        int i = 0;
        while (!isAllDead()) {
            i = (i + count - 1) % people;
            while (state[i]) {
                i = (i + 1) % people;
                if (isAllDead())
                    break;
            }
            if (state[i] == false) {
                state[i] = true;
                System.out.println(i);
            }
            while (state[i]) {
                i = (i + 1) % people;
                if (isAllDead())
                    break;
            }
        }
    }
}
