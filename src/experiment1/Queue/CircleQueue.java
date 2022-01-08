package experiment1.Queue;

public class CircleQueue {
    int [] circleQueue;
    int front;
    int rear;

    public CircleQueue(int MaxLen) {  
        this.circleQueue = new int[MaxLen];
        this.front = 0;
        this.rear = 0;
    }
    //初始化循环队列
    void initCircleQueue() {
    	front = rear = 0;
    }

    //判断队空
    public boolean emptyCircleQueue() {
    	if (front == rear) return true;
    	else return false;
    }
    //元素入队
    public boolean inCircleQueue(int inData) {
        //判断队列是否满
        if (front == (rear + 1) % circleQueue.length) {
            System.out.println("队列已经满了,入队失败");
            return false;
        }
        circleQueue[rear] = inData;
        rear = (rear + 1) % circleQueue.length;
        return true;
    }

    //出队
    public int outCircleQueue() {
    	//判断队列是否为空
    	if (this.emptyCircleQueue()) {
            System.out.println("队列为空,出队失败");
    		return -1;
    	}
    	int outData = circleQueue[front];
    	front = (front + 1) % circleQueue.length;
    	return outData;
    }
    //打印队列
    public void printCircleQueue() {
    	//判断队列是否为空
    	if (this.emptyCircleQueue()) {
            System.out.println("队列为空,出队失败");
    		return;
    	}
    	int i = front;
    	while (i != rear) {
            System.out.print(circleQueue[i%circleQueue.length]+" ");
    		i++;
    	}
    }
}
