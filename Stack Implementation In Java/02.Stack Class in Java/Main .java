//Stack Extends vector class and comes with five function
import java.util.Stack;
class Main{
public static void main(String[] args) {
    Stack<Integer> st=new Stack<>();

    //To Add An Element We Use 
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
    st.push(5);
    st.push(6);


    //To Pop An Element we use
    st.pop();//Removes from tos

    //to look at stack top we use
    // st.peek();
    System.out.println(st.peek());

    //To Check Whether the stack is empty
    System.out.println(st.isEmpty());

    //To search an element
    System.out.println(st.search(1));

    //Print the stack
    System.out.println(st);
}
}