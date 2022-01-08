package experiment1.BinarySortTree;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class TestBinarySortTree {
    public static void ShowMenu(){
        System.out.println("*************  请选择你要进行的操作 **************");
        System.out.println("*************  1.创 建  二  叉  树 **************");
        System.out.println("*************  2.删 除 指 定 结 点 **************");
        System.out.println("*************  3.查   找   元   素 **************");
        System.out.println("*************  0.退             出 **************");
    }
    public static void main(String[] args) {
        ShowMenu();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        BinarySortTree myBinarySortTree = new BinarySortTree();
        while(num != 0){
            if (num == 1){//创建排序二叉树
                //创建有序表
                ArrayList<Integer> dataList = new ArrayList<>();
                input.nextLine();
                System.out.println("请输入元素(按“q”结束创建)");
                String data = input.nextLine();
                while(!data.equals("q")){
                    int intData = Integer.parseInt(data);
                    dataList.add(intData);
                    data = input.nextLine();
                }
                Collections.sort(dataList);
                Integer[] integerData = dataList.toArray(new Integer[dataList.size()]);
                System.out.println("有序表创建完成!");
                System.out.println("创建的有序表为:");
                //打印有序表
                for(int i = 0; i < integerData.length; i++){
                    System.out.print(integerData[i].intValue()+" ");
                }
                System.out.println();
                //根据有序表创建二叉排序树
                myBinarySortTree.root = myBinarySortTree.createBST(integerData);
                System.out.println("排序二叉树创建完成!根节点为:"+myBinarySortTree.root.data);
                System.out.println("中序遍历序列为:");
                myBinarySortTree.InOrderTraverse(myBinarySortTree.root);
            }
            else if(num == 2){
                //删除结点
                System.out.println("请输入要删除的结点:");
                int delData = input.nextInt();
                myBinarySortTree.delBSTNode(myBinarySortTree.root,delData);
                System.out.println("结点删除完成");
                System.out.println("中序遍历序列为:");
                myBinarySortTree.InOrderTraverse(myBinarySortTree.root);
                
            }
            else {
                //查找元素
                System.out.println("请输入要查找的元素:");
                int searchData = input.nextInt();
                treeNode p = null;
                boolean find = myBinarySortTree.binarySearch(myBinarySortTree.root,p,searchData);
                System.out.println("查找结果为:"+find);
            }
            ShowMenu();
            num = input.nextInt();
        }
        input.close();
    }
}
