/**
 * Created by pu on 2015/8/25/025.
 */

import java.util.Iterator;

public class uniQueue<Item> implements Iterable<Item> {
    private node first;
    private node last;
    private LinearProbingHashST<Item, Integer> list;

    private class node {
        Item item;
        node next;
    }

    private int N;

    public uniQueue() {
        list = new LinearProbingHashST<>();
    }

    public uniQueue(uniQueue<Item> a) {
        list = new LinearProbingHashST<>();
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
        if (list.contains(item)) return;
        list.put(item, 1);
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

    public void concat(uniQueue<Item> a) {
        node tmp = first;
        while (tmp.next != null)
            tmp = tmp.next;
        tmp.next = a.first;
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

    private class QueueIterator implements Iterator<Item> {
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

