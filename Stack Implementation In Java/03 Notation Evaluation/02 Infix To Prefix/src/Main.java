import java.util.Stack;
import java.util.Scanner;

class PreFix{
    private int precedence(char c)
    {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    private int associativity(char c)
    {
        // 1 for left to right
        // 0 for right to left
        if(c=='+'||c=='-'||c=='*'||c=='/')
        {
            return 1;
        }
        return 0;
    }

    private boolean operand(char c)
    {
        if(c>=65 && c<=90)
        {
            return true;
        }
        else if(c>=97&& c<=122)
        {
            return true;
        }
        else return c >= 48 && c <= 57;
    }

    private boolean operator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
    public String prefix(String s)
    {
        Stack<Character> stack= new Stack<>();
        char [] infix=s.toCharArray();
        String res="";
        for (char c : infix) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            if (c == '}') {
                while (stack.peek() != '{' && !stack.isEmpty()) {

                    res=res+stack.pop();
                }
                stack.pop();
            }
            if (c == ']') {
                while (stack.peek() != '[' && !stack.isEmpty()) {

                    res=res+stack.pop();
                }
                stack.pop();
            }

            if (c == ')') {
                while (stack.peek() != '(' && !stack.isEmpty()) {
                    res=res+stack.pop();
                }
                stack.pop();
            }

            if (operand(c)) {
                res=res+c;
            }
            if (operator(c)) {
                if(!stack.isEmpty()){
                if (precedence(c) == precedence(stack.peek())) {
                    switch (associativity(c)) {
                        case 1 -> {
                            if (stack.peek() == c) {
                                stack.push(c);
                                break;
                            }
                            if (!stack.isEmpty()) {
                                res=res+stack.pop();
                            }
                            stack.push(c);
                        }
                        case 0 -> stack.push(c);
                    }
                }

                if (precedence(c) > precedence(stack.peek())) {
                    stack.push(c);
                }
                    if (precedence(c) < precedence(stack.peek())) {
                        while (!stack.isEmpty()&&(precedence(stack.peek())>=precedence(c))) {
                            res=res+stack.pop();
//                            System.out.print(stack.pop());
                        }
                        stack.push(c);
                    }

            }

            else {
            stack.push(c);
            }
            }
        }

        while (!stack.isEmpty()){
            if(operator(stack.peek()))
            {
                res=res+stack.pop();
            }
            else {
                stack.pop();
            }
        }
        return res;
    }
}
class Reverse
{
    public String reverse(String s)
    {
        String result="";
        for(int i=s.length()-1;i>=0;i--)
        {
            result=result+s.charAt(i);
        }
        return result;
    }
}
public class Main{
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter The String in Infix Form");
        String infix=sc.next();

        Reverse rev= new Reverse();
        String reversed=rev.reverse(infix);

        PreFix pf = new PreFix();
        String pre=pf.prefix(reversed);
//        System.out.println(pre);
        String Final=rev.reverse(pre);
        System.out.println("Prefix :");
        System.out.println(Final);
        
    }
}