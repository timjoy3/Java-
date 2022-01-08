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

}
