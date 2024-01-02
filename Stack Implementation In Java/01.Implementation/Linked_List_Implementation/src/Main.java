//Node Class
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}
//Stack Class
class Stack
{
  Node top;
  private int size;
  Stack(int size)
  {
      this.top=null;
      this.size=size;
  }
  public void push(int data)
  {
      if(this.size!=0)
      {
          Node node=new Node(data);
          node.next=this.top;
          this.top=node;
          this.size=this.size-1;
      }
      else
      {
          System.out.println(" Stack OverFlow ");
      }
  }
    public void pop() {
        {
            if(this.top!=null)
            {
                Node temp=this.top;
                this.top=(this.top).next;
                System.out.printf("%d Popped\n",temp.data);
            }
            else {
                System.out.println("UnderFlow");
            }
        }}
    public int peek()
        {
            return this.top.data;
        }
        public void show()
        {
            Node temp=this.top;
            while (temp!=null)
            {
                System.out.println(temp.data);
                temp=temp.next;
            }
        }
  }
class Main
{
    public static void main(String[] args) {
        Stack stack=new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.peek();
        stack.pop();
        stack.show();

    }
}