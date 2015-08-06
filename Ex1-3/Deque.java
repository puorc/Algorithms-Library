/**
 * Created by ZhaoPu on 2015/7/31.
 */

import java.util.NoSuchElementException;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private int N;
    private node first;
    private node last;

    private class node {
        Item item;
        node prev;
        node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void pushLeft(Item item) {
        node tmp = new node();
        tmp.item = item;
        tmp.next = null;
        tmp.prev = null;
        if (first == null && last == null)
            first = last = tmp;
        else {
            first.prev = tmp;
            tmp.next = first;
            first = tmp;
        }
        N++;
    }

    public void pushRight(Item item) {
        node tmp = new node();
        tmp.item = item;
        tmp.next = null;
        tmp.prev = null;
        if (first == null && last == null)
            first = last = tmp;
        else {
            last.next = tmp;
            tmp.prev = last;
            last = tmp;
        }
        N++;
    }

    public Item popLeft() {
        if (isEmpty()) throw new NoSuchElementException("Empty!");
        Item tmp = first.item;
        if (this.size() == 1)
            first = last = null;
        else
            first = first.next;
        N--;
        return tmp;
    }

    public Item popRight() {
        if (isEmpty()) throw new NoSuchElementException("Empty!");
        Item tmp = last.item;
        if (this.size() == 1)
            first = last = null;
        else
            last = last.prev;
        N--;
        return tmp;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private node current = first;

        public void remove() {
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item tmp = current.item;
            current = current.next;
            return tmp;
        }
    }
}
