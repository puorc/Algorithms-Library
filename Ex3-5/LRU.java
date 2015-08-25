/**
 * Created by pu on 2015/8/25/025.
 */
public class LRU<Item> {
    private node first;
    private node rear;

    private class node {
        node next;
        node prev;
        Item item;
    }

    private void addToHead(Item item) {
        if (first == null) {
            first = rear = new node();
            first.item = item;
            return;
        }
        node tmp = new node();
        tmp.item = item;
        tmp.prev = null;
        tmp.next = first;
        first.prev = tmp;
        first = tmp;
    }

    public void visit(Item item) {
        if (first == null) {
            addToHead(item);
            return;
        }
        node tmp = first;
        if (item.equals(first.item)) return;
        tmp = tmp.next;
        while (tmp != null) {
            if (tmp.item.equals(item)) {
                tmp.prev.next = tmp.next;
                tmp.next.prev = tmp.prev;
                addToHead(item);
                return;
            }
            tmp = tmp.next;
        }
        addToHead(item);
    }

    public Item delete() {
        Item item = rear.item;
        rear = rear.prev;
        if (rear != null) {
            rear.next = null;
        }
        return item;
    }
}
