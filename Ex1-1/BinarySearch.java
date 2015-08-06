import java.util.Arrays;

/**
 * Created by pu on 2015/7/27.
 */
public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] == key)
                return mid;
            else if (a[mid] > key)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 5, 7, 8, 6, 4, 10};
        Arrays.sort(numbers);
        System.out.println(rank(7, numbers));
    }
}
