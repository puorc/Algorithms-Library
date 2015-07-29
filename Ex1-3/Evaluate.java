/**
 * Created by pu on 2015/7/29.
 */
import java.util.Stack;
public class Evaluate {
    public static void main(String[] args) {
        Stack<Double> vals=new Stack<>();
        Stack<String> ops=new Stack<>();
        while(!StdIn.isEmpty()){
            String s=StdIn.readString();
            if(s.equals("("));
            else if(s.equals("+"))  ops.push(s);
            else if(s.equals("-"))  ops.push(s);
            else if(s.equals("*"))  ops.push(s);
            else if(s.equals("/"))  ops.push(s);
            else if(s.equals(")")){
                String op=ops.pop();
                double val=vals.pop();
                if(op.equals("+"))  vals.push(val+vals.pop());
                if(op.equals("-"))  vals.push(val-vals.pop());
                if(op.equals("*"))  vals.push(val*vals.pop());
                if(op.equals("/"))  vals.push(val/vals.pop());
            }
            else
                vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
        System.out.println("a");
    }
}
