class Stack
{
    private int [] stack;
    private int top;
    private int size;
    Stack(int size)
    {
        this.size=size;
        this.top=-1;
        this.stack=new int[size];
    }
    public void push(int data)
    {
        if(!this.isFull()) {
            this.top = this.top + 1;
            this.stack[this.top] = data;
            System.out.printf("%d pushed into the stack \n", data);
        }
        else {
            System.out.println("Stack Overflow");
        }
    }
    public void pop()
    {
        if(!this.isEmpty())
        {
            int temp=this.stack[this.top];
            this.top=this.top-1;
            System.out.printf("%d popped from the stack \n",temp);
    }}
    public void peek()
    {
        System.out.printf("%d is at peek of the stack \n",this.stack[this.top]);
    }
    public boolean isEmpty()
    {
       if(this.top==-1)
       {
           return true;
       }
       return false;
    }
    public boolean isFull()
    {
        if(this.top==size-1)
        {
            return true;
        }
        return false;
    }
    public void show()
    {
        int top=this.top;
        while(top!=-1)
        {
            System.out.println(this.stack[top]);
            top--;
        }
    }

}
public class Main {
    public static void main(String[] args) {
        Stack stack=new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.show();
        stack.pop();
    }
}