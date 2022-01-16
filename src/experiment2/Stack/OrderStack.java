package experiment2.Stack;

public class OrderStack {
    public int maxSize;
    public int top = -1;
	public int [] orderStack;

    public OrderStack(int maxSize){
        this.maxSize=maxSize;
        orderStack=new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top==maxSize-1;
    }
    
    //栈空    
    public boolean isEmpty() {
        return top==-1;
    }

    public void pushOrderStack(int value) {
        //先判断是否栈满了
        if(isFull()) {
            System.out.println("栈已经满了~");
            return;
        }else {
            top++;
            orderStack[top]=value;
        }
    }

     //出栈-pop
     public int popOrderStack() {
        if(isEmpty()) {
            System.out.println("栈空，无法出栈");
        }
        int value=orderStack[top];
        top--;
        return value;
    }

    //遍历栈
    public void printOrderStack() {
        if(isEmpty()) {
            System.out.println("栈空，没有数据");
        }
        for(int i=top;i>=0;i--) {
            System.out.print(orderStack[i]);
        }
        System.out.println();
    }

}
