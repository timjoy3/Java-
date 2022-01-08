package experiment1.LinkList;

import java.util.Scanner;

public class Test_LinkList{

    public static void ShowMenu(){
        System.out.println("*************  请选择你要进行的操作 **************");
        System.out.println("*************  1.创   建   链   表 **************");
        System.out.println("*************  2.链   表   排   序 **************");
        System.out.println("*************  3.删   除   元   素 **************");
        System.out.println("*************  0.退             出 **************");
    }
    public static void main(String[] args) {
        ShowMenu();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        LinkList myLinkList = new LinkList();//初始化链表
        while(num != 0){
            if (num == 1){
                //创建链表
                input.nextLine();
                System.out.println("请输入链表元素(按“q”结束创建)");
                String data = input.nextLine();
                while(!data.equals("q")){
                    int intData = Integer.parseInt(data);
                    System.out.println("添加元素"+ intData);
                    myLinkList.addNode(intData);
                    data = input.nextLine();
                }
                System.out.println("链表创建完成!");
                System.out.println("创建的链表为:");
                myLinkList.printList();
            }
            else if(num == 2){
                //链表排序 
                System.out.println("排序前链表为:");
                myLinkList.printList();
                myLinkList.linkSort();//排序
                System.out.println("排序后链表为:");
                myLinkList.printList();
            }
            else {
                //删除元素
                System.out.println("删除前链表为:");
                myLinkList.printList();
                System.out.println("请输入要删除的元素");
                int delData = input.nextInt();
                System.out.println("要删除的元素为:"+delData);
                boolean status = myLinkList.deleteNodeAll(delData);
                
                System.out.println("删除状态为"+status+"删除后链表为:");
                myLinkList.printList();
            }
            ShowMenu();
            num = input.nextInt();
        }
        input.close();
    }


}
