/**
 * Created by pu on 2015/7/29.
 */
import java.util.Stack;
public class Evaluate {
    public static void main(String[] args) {
        Stack<Double> vals=new Stack<>();
        Stack<Character> ops=new Stack<>();
        char[] input=args[0].toCharArray();
        for(int i=0;i<input.length;i++){
            if(input[i]=='(');
            else if(input[i]=='+')  ops.push(input[i]);
            else if(input[i]=='-')  ops.push(input[i]);
            else if(input[i]=='*')  ops.push(input[i]);
            else if(input[i]=='/')  ops.push(input[i]);
            else if(input[i]==')'){
                char op=ops.pop();
                double val=vals.pop();
                if(op=='+')  vals.push(val+vals.pop());
                else if(op=='-')  vals.push(val-vals.pop());
                else if(op=='*')  vals.push(val*vals.pop());
                else if(op=='/')  vals.push(val/vals.pop());
            }
            else
                vals.push(input[i]-48.0);
        }
        System.out.println(vals.pop());
    }
}
