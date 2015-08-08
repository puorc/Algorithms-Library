/**
 * Created by pu on 2015/8/8/008.
 */

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {
    private node first;
    private node current;

    private class node {
        Item item;
        node next;
    }

    public LinkedList() {
    }

    public LinkedList(Object[] a) {
        for (Object i : a)
            append((Item) i);
    }

    public void append(Item item) {
        node tmp = new node();
        tmp.item = item;
        tmp.next = null;
        if (first == null)
            first = current = tmp;
        else {
            current.next = tmp;
            current = current.next;
        }
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {
        private node _current = first;

        public boolean hasNext() {
            return _current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item tmp = _current.item;
            _current = _current.next;
            return tmp;
        }
    }
}
