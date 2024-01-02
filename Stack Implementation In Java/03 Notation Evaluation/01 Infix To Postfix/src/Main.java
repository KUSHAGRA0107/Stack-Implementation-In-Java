import java.util.Stack;
import java.util.Scanner;

class PostFix{
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
    public void postfix(String s)
    {
        Stack<Character> stack= new Stack<>();
        char [] infix=s.toCharArray();
        for (char c : infix) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            if (c == '}') {
                while (stack.peek() != '{' && !stack.isEmpty()) {

                    System.out.print(stack.pop());
                }
                stack.pop();
            }
            if (c == ']') {
                while (stack.peek() != '[' && !stack.isEmpty()) {

                    System.out.print(stack.pop());
                }
                stack.pop();
            }

            if (c == ')') {
                while (stack.peek() != '(' && !stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                stack.pop();
            }

            if (operand(c)) {
                System.out.print(c);
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
                                System.out.print(stack.pop());
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
                            System.out.print(stack.pop());
                    }
                    stack.push(c);
                }

            }
        else
    {
        stack.push(c);
    }
            }
        }

            while (!stack.isEmpty()){
               if(operator(stack.peek()))
               {
                   System.out.print(stack.pop());
               }
               else {
                   stack.pop();
               }
            }
    }
}

public class Main{
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter The String in Infix Form");
        String infix=sc.next();
        System.out.println(infix);
        System.out.println("PostFix:");
        PostFix pf=new PostFix();
        pf.postfix(infix);

    }
}