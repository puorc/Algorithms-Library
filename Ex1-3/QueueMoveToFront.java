/**
 * Created by ZhaoPu on 2015/8/1.
 */
public class QueueMoveToFront extends Queue<Character> {
    public QueueMoveToFront(){
        super();
    }
    public node hasIt(char c){
        node current=this.getFirst();
        while(current.next!=null){
            if(current.next.item==c)
                return current;
            current=current.next;
        }
        return null;
    }
    public boolean isRemoved(char c){
        if(hasIt(c)==null) return false;
        else{
            node current=hasIt(c);
            current.next=current.next.next;
            return true;
        }
    }
    public void pushToHead(char c){
        node current=this.getFirst();
        first=new node();
        first.item=c;
        first.next=current;
    }
    public void print(){
        node current=this.getFirst();
        while(current!=null){
            System.out.println(current.item+' ');
            current=current.next;
        }
    }
}
