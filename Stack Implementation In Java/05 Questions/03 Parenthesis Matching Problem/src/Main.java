import java.util.Scanner;
import java.util.Stack;

class Balanced_parenthesis_check
{
private Stack<Character> stack=new Stack<>();
public boolean check_for_vp(String s)
{
    for(int i=0;i<s.length();i++)
    {
        //if any opening bracket encountered just push it into the stack
        if((s.charAt(i)=='(')||(s.charAt(i)=='[')||s.charAt(i)=='{')
        {
            stack.push(s.charAt(i));
        }
        //there are multiple type of parenthesis involved so we need to check for the particular type i.e },],)
        if(s.charAt(i)==']')
        {
            if(stack.isEmpty())
            {
                return false;
            }
            else {
                if(stack.pop()!='[')
                {
                    return  false;
                }
            }
        }
        if(s.charAt(i)==')')
        {
            if(stack.isEmpty())
            {
                return false;
            }
            else {
                if(stack.pop()!='(')
                {
                    return  false;
                }
            }
        }
        if(s.charAt(i)=='}')
        {
            if(stack.isEmpty())
            {
                return false;
            }
            else {
                if(stack.pop()!='{')
                {
                    return  false;
                }
            }
        }
    }
    if(!stack.isEmpty())
    {
        return false;
    }
    return true;
}

}
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("!!Enter Your String!!");
        String s=sc.next();
        System.out.println("Original String is "+s);
        Balanced_parenthesis_check check=new Balanced_parenthesis_check();
        System.out.println(check.check_for_vp(s));

    }
}