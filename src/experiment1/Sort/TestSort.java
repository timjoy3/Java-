package experiment1.Sort;
import experiment1.LinkList.*;

import java.util.Random;
import java.util.Scanner;

public class TestSort {
    public static void ShowMenu(){
        System.out.println("*************  请选择你要进行的操作 **************");
        System.out.println("*************  1.创   建   链   表 **************");
        System.out.println("*************  2.插   入   排   序 **************");
        System.out.println("*************  3.冒   泡   排   序 **************");
        System.out.println("*************  4.快   速   排   序 **************");
        System.out.println("*************  5.归   并   排   序 **************");
        System.out.println("*************  6.堆     排      序 **************");
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
                System.out.println("请输入链表长度:");
                int length = input.nextInt();
                for(int i = 0;i < length;i++){
                    Random rnd = new Random();
                    int Data = rnd.nextInt(100);
                    myLinkList.addNode(Data);
                }
                System.out.println("链表创建完成!");
                System.out.println("创建的链表为:");
                myLinkList.printList();
            }
            else if(num == 2){
                //插入排序
                Sort sort = new Sort();
                System.out.println("排序前链表为:");
                myLinkList.printList();
                sort.insertSort(myLinkList.head);//插入排序
                System.out.println("排序后链表为:");
                myLinkList.printList();
            }
            else if(num == 3){
                //冒泡排序
                Sort sort = new Sort();
                System.out.println("排序前链表为:");
                myLinkList.printList();
                sort.bubbleSort(myLinkList.head);//冒泡排序
                System.out.println("排序后链表为:");
                myLinkList.printList();
            }
            else if(num == 4){
                //快速排序
                Sort sort = new Sort();
                System.out.println("排序前链表为:");
                myLinkList.printList();
                Node p = myLinkList.head;
                Node tail = null;
			    while (p != null) {
				    tail = p;
				    p = p.next;
			    }
                sort.quickSort(myLinkList.head, tail);//快速排序
                System.out.println("排序后链表为:");
                myLinkList.printList();
            }
            else if(num == 5){
                //归并排序
                Sort sort = new Sort();
                System.out.println("排序前链表为:");
                myLinkList.printList();
                myLinkList.head = sort.mergeSort(myLinkList.head);//归并排序
                System.out.println("排序后链表为:");
                myLinkList.printList();
            }
            else if(num == 6){
                //堆排序
                System.out.println("请输入数组元素个数:");
                int listLen = input.nextInt();
                int [] list = new int[listLen];
                for (int i = 0; i < listLen; i++){
                    Random rnd = new Random();
                    list[i] = rnd.nextInt(100);
                }
                Sort sort = new Sort();
                System.out.println("排序前数组为:");
                for (int j = 0; j <listLen; j++){
                    System.out.print(list[j]+" ");
                }
                // myLinkList.printList();
                sort.DumpSort(list);//堆排序
                System.out.println("排序后数组为:");
                for (int k = 0; k <listLen; k++){
                    System.out.print(list[k]+" ");
                }
            }
            ShowMenu();
            num = input.nextInt();
        }
        input.close();
    }
}
