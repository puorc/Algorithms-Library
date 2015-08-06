/**
 * Created by ZhaoPu on 2015/7/30.
 */

import java.util.Iterator;
import java.util.Random;

public class RandomBag<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        private Item[] a = (Item[]) new Object[N];
        private int[] random = new int[N];

        public ListIterator() {
            for (int i = 0; i < N; i++) {
                a[i] = current.item;
                current = current.next;
            }
        }

        public void remove() {
        }

        public boolean hasNext() {
            for (int i = 0; i < N; i++)
                if (random[i] == 0)
                    return true;
            return false;
        }

        private int Random(int min, int max) {
            Random rand = new Random();
            int randomNum = rand.nextInt((max - min) + 1) + min;
            return randomNum;
        }

        public Item next() {
            int theRandom = Random(0, N - 1);
            while (random[theRandom] != 0)
                theRandom = Random(0, N - 1);
            random[theRandom] = 1;
            return a[theRandom];
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
}
