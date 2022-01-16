package experiment2.Stack;
import java.util.Scanner;

public class TestLinkStack {
    public static void ShowMenu(){
        System.out.println("*************  请选择你要进行的操作 **************");
        System.out.println("*************  1.创     建      栈 **************");
        System.out.println("*************  2.入             栈 **************");
        System.out.println("*************  3.出             栈 **************");
        System.out.println("*************  0.退             出 **************");
    }

    public static void main(String[] args) {
        ShowMenu();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        LinkStack myLinkStack = new LinkStack();
        myLinkStack.initLinkStack();//初始化栈
        while(num != 0){
            if (num == 1){
                //创建栈
                input.nextLine();
                System.out.println("请输入栈元素(按“q”结束创建)");
                String data = input.nextLine();
                while(!data.equals("q")){
                    int intData = Integer.parseInt(data);
                    myLinkStack.pushLinkStack(intData);//入栈
                    data = input.nextLine();
                }
                System.out.println("栈创建完成!");
                System.out.println("创建的栈为:");
                myLinkStack.printLinkStack();
            }
            else if(num == 2){
                //入栈
                System.out.println("入栈前栈为:");
                myLinkStack.printLinkStack();
                System.out.println("请输入要入栈的元素");
                int inData = input.nextInt();
                myLinkStack.pushLinkStack(inData);
                System.out.println("入栈后栈为:");
                myLinkStack.printLinkStack();
            }
            else {
                //出栈
                System.out.println("出栈前栈为:");
                myLinkStack.printLinkStack();
                int outData = myLinkStack.popLinkStack();
                System.out.println("出栈元素为:"+outData+"出栈后栈为:");
                myLinkStack.printLinkStack();
            }
            ShowMenu();
            num = input.nextInt();
        }
        input.close();
    }
}
