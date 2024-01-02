import java.util.Stack;
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String>stack=new Stack<>();
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                stack.push("(");
            }
            else if (stack.peek()=="(")
            {
                stack.pop();
                stack.push("1");
            }
            else
            {
                long count=0;
                while(stack.peek()!="(")
                {
                    count=count+Integer.parseInt(stack.peek());
                    stack.pop();
                }
                stack.pop();
                stack.push(String.valueOf(2 * count));
            }
        }
        while(!stack.isEmpty())
        {
            result=result+Integer.parseInt(stack.peek());
            stack.pop();
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
    Solution leetcode=new Solution();
        System.out.println(leetcode.scoreOfParentheses("()()()()((()))"));
    }
}