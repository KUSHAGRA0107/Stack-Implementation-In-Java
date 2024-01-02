import java.util.Stack;

public class Valid_Parenthesis {
    public static boolean check() {
        Stack<Character>stack=new Stack<>();
        String s="{}[])";
        if(s.length()%2!=0)
        {
            return  false;
        }
        char[] ch=s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if(!stack.isEmpty()) {
                if ((ch[i] == '(') || (ch[i] == '{') || (ch[i] == '[')) {
                    stack.push(ch[i]);
                }
                if (ch[i] == ')') {
                    if (stack.pop() != '(') {
                        return false;
                    }
                }
                if (ch[i] == ']') {
                    if (stack.pop() != '[') {
                        return false;
                    }
                }
                if (ch[i] == '}') {
                    if (stack.pop() != '{') {
                        return false;
                    }
                }
            }
        else
            {
                return false;
            }
        }
        return true;
        stack.peek()
    }
    public static void main(String[] args) {
        System.out.println(check());

    }
}
