package experiment1.Queue;
/*实现队列的链式存储 */

//定义结点
class Node {
    Node next = null;//下一个结点
    int data;//结点数据
    public Node(int data){
        this.data = data;
    }
}

public class LinkQueue {
    //定义头结点和尾结点
    Node head = null;
    Node rear = null;

    //初始化队列
    public void initLinkQueue(){
        head = rear = null;
    }

    //入队
    public void inLinkQueue(int inData) {
        Node newNode = new Node(inData);//新建结点
        newNode.next = null;
        if (rear == null)
            head = rear = newNode;
        else
            rear = rear.next = newNode;
    }

    //出队
    public int outLinkQueue(){
        if(head == null){
            System.out.println("队列为空，出队失败!");
            return -1;
        }
        int temp = head.data;
        Node p = head;
        head = p.next;
	    if (head == null)
	    	rear = null;
	    return temp;
    }

    //判断队列是否为空
    boolean EmptyQueue() {
    	return rear == null;
    }

    //打印队列
    void printLinkQueue() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data +" ");
            node = node.next;
        }
    }
}
