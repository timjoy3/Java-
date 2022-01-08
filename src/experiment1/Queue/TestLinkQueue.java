package experiment1.Queue;
import java.util.Scanner;

public class TestLinkQueue {
    public static void ShowMenu(){
        System.out.println("*************  请选择你要进行的操作 **************");
        System.out.println("*************  1.创   建   队   列 **************");
        System.out.println("*************  2.入             队 **************");
        System.out.println("*************  3.出             队 **************");
        System.out.println("*************  0.退             出 **************");
    }
    public static void main(String[] args) {
        ShowMenu();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        LinkQueue myLinkQueue = new LinkQueue();
        myLinkQueue.initLinkQueue();//初始化链队列
        while(num != 0){
            if (num == 1){
                //创建队列
                input.nextLine();
                System.out.println("请输入队列元素(按“q”结束创建)");
                String data = input.nextLine();
                while(!data.equals("q")){
                    int intData = Integer.parseInt(data);
                    // System.out.println("添加元素"+ intData);
                    myLinkQueue.inLinkQueue(intData);//入队
                    data = input.nextLine();
                }
                System.out.println("队列创建完成!");
                System.out.println("创建的队列为:");
                myLinkQueue.printLinkQueue();
            }
            else if(num == 2){
                //入队
                System.out.println("入队前队列为:");
                myLinkQueue.printLinkQueue();
                System.out.println("请输入要入队的元素");
                int inData = input.nextInt();
                myLinkQueue.inLinkQueue(inData);
                System.out.println("入队后队列为:");
                myLinkQueue.printLinkQueue();
            }
            else {
                //出队
                System.out.println("出队前队列为:");
                myLinkQueue.printLinkQueue();
                myLinkQueue.outLinkQueue();
                System.out.println("出队后队列为:");
                myLinkQueue.printLinkQueue();
            }
            ShowMenu();
            num = input.nextInt();
        }
        input.close();
    }
}
