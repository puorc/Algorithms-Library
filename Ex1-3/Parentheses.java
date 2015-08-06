/**
 * Created by ZhaoPu on 2015/8/1.
 */
public class Parentheses {
    public static boolean isComplete(char[] c) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(' || c[i] == '{' || c[i] == '[')
                stack.push(c[i]);
            else if (c[i] == ')') {
                if (stack.pop() != '(')
                    return false;
            } else if (c[i] == '}') {
                if (stack.pop() != '{')
                    return false;
            } else if (c[i] == ']')
                if (stack.pop() != '[')
                    return false;
                else
                    return stack.isEmpty();
        }
        return stack.isEmpty();
    }
}
