import java.util.Scanner;
class MultipleStack{
    int [] stack;
    int top1;
    int top2;
    int size;
    MultipleStack(int size)
    {
        this.size=size;
        stack=new int [size];
        top1=-1;
        top2=size;
    }
    public void push1(int data)
    {
        if(this.top1<=this.top2-1)
        {
            this.top1++;
            this.stack[this.top1]=data;
        }
        else {
            System.out.println("Stack 1 Has OverFlowed ");
        }
    }
    public void push2(int data)
    {
        if(this.top2>this.top1+1)
        {
            this.top2--;
            this.stack[this.top2]=data;
        }
        else {
            System.out.println("Stack 2 Has OverFlowed ");
        }
    }
    public void pop1()
    {
        if(this.top1==-1)
        {
            System.out.println("Stack 1 Has Under flowed ");
        }
        else {
            System.out.printf("%d Popped From stack 1 \n", this.stack[this.top1]);
            this.top1--;
        }
    }
    public void pop2()
    {
        if(this.top1==this.size)
        {
            System.out.println("Stack 2 Has Under flowed ");
        }
        else {
            System.out.printf("%d Popped From stack 1 \n", this.stack[this.top2]);
            this.top2++;
        }
    }

    public void display()
    {
        System.out.println("Stack 1");
        int stack1=this.top1;
        while(stack1!=-1)
        {
            System.out.printf("%d-->",this.stack[stack1]);
            stack1--;
        }
        System.out.println();
        System.out.println("Stack 2");
        int stack2=this.top2;
        while(stack2!=this.size)
        {
            System.out.printf("%d-->",this.stack[stack2]);
            stack2++;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Size of Multiple Stack");
        int size=sc.nextInt();
        MultipleStack ms=new MultipleStack(size);
        ms.push1(1);
        ms.push1(2);
        ms.push1(3);
        ms.push1(4);
        ms.push1(5);

        ms.push2(9);
        ms.push2(8);
        ms.push2(7);
        ms.push2(6);
        ms.push2(5);

        ms.pop1();
        ms.pop2();
        ms.display();
    }
}