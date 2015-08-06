/**
 * Created by ZhaoPu on 2015/8/1.
 */
public class MoveToFront {
    public static void perform(char[] c) {
        QueueMoveToFront a = new QueueMoveToFront();
        for (char b : c) {
            if (a.isRemoved(b))
                a.pushToHead(b);
            else
                a.enqueue(b);
        }
        a.print();
    }

    public static void main(String[] args) {
        System.out.println("sa");
    }
}
