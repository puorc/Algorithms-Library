/**
 * Created by ZhaoPu on 2015/7/30.
 */

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    protected node first;
    protected node last;

    protected class node {
        Item item;
        node next;
    }

    private int N;

    public Queue() {
    }

    public Queue(Queue<Item> a) {
        node current = a.getFirst();
        while (current != null) {
            this.enqueue(current.item);
            current = current.next;
        }
    }

    public node getFirst() {
        return first;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        node oldlast = last;
        last = new node();
        last.item = item;
        last.next = null;
        if (oldlast == null) {
            first = last;
        } else {
            oldlast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Item tmp = first.item;
        if (N == 1) first = last = null;
        else first = first.next;
        N--;
        return tmp;
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    protected class QueueIterator implements Iterator<Item> {
        private node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item tmp = current.item;
            current = current.next;
            return tmp;
        }
    }
}
