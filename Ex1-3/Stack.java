/**
 * Created by ZhaoPu on 2015/7/30.
 */
import java.util.Iterator;
public class Stack<Item> implements Iterable<Item>  {
    private node first;
    private class node{
        Item item;
        node next;
    }
    private int N;
    public Stack(){}
    public Stack(Stack<Item> a){
        Stack<Item> TempStack=new Stack<>();
        node tmp=a.getFirst();
        while(tmp!=null){
            TempStack.push(tmp.item);
            tmp=tmp.next;
        }
        while(!TempStack.isEmpty()){
            this.push(TempStack.pop());
        }
    }
    public node getFirst() { return first; }
    public void push(Item item){
        node oldfirst=first;
        first=new node();
        first.item=item;
        first.next=oldfirst;
        N++;
    }
    public boolean isEmpty(){ return N==0; }
    public int size(){ return N; }
    public Item pop(){
        Item tmp=first.item;
        first=first.next;
        N--;
        return tmp;
    }
    public Iterator<Item> iterator(){ return new StackIterator(); }
    private class StackIterator implements Iterator<Item>{
        private node current=first;
        public boolean hasNext(){ return current!=null; }   // error not current.next
        public void remove(){}
        public Item next(){
            Item tmp=current.item;
            current=current.next;
            return tmp;
        }
    }
}
