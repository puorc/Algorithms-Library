/**
 * Created by ZhaoPu on 2015/8/1.
 */
import java.util.UnknownFormatConversionException;
import java.util.NoSuchElementException;
public class Buffer {
    private int N;
    private Stack<Character> Left;
    private Stack<Character> Right;
    public Buffer(){
        Left=new Stack<>();
        Right=new Stack<>();
    }
    public void insert(char c){
        Left.push(c);
    }
    char delete(){
        if(Left.isEmpty()) throw new NoSuchElementException("No more char");
        char c=Left.pop();
        return c;
    }
    public void left(int k){
        for(int i=0;i<k;i++){
            if(Left.isEmpty())
                break;
            Right.push(Left.pop());
        }
    }
    public void right(int k){
        if(k<0) throw new UnknownFormatConversionException("Invalid");
        if(k<=Right.size())
            for(int i=0;i<k;i++)
                Left.push(Right.pop());
        else{
            while(!Right.isEmpty())
                Left.push(Right.pop());
            for(int j=0;j<k-Right.size();j++)
                Left.push(' ');      // Still there are bugs
        }
    }
    public int size(){
        return Left.size()+Right.size();
    }
}
