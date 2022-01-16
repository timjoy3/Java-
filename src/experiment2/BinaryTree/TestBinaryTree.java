package experiment2.BinaryTree;
import java.util.LinkedList;
import java.util.Scanner;

public class TestBinaryTree {
    public static void ShowMenu(){
        System.out.println();
        System.out.println("*************  请选择你要进行的操作 **************");
        System.out.println("*************  1.创  建  二  叉 树 **************");
        System.out.println("*************  2.递 归 先 序 遍 历 **************");
        System.out.println("*************  3.递 归 中 序 遍 历 **************");
        System.out.println("*************  4.递 归 后 序 遍 历 **************");
        System.out.println("*************  5.非递归先 序 遍 历 **************");
        System.out.println("*************  6.非递归中 序 遍 历 **************");
        System.out.println("*************  7.非递归后 序 遍 历 **************");
        System.out.println("*************  0.退            出 **************");
    }

    public static void main(String[] args) {
        ShowMenu();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        BinaryTree myBinaryTree = new BinaryTree();
        while(num != 0){
            if (num == 1){
                //创建二叉树
                input.nextLine();
                System.out.println("请输入构造二叉树的元素,#表示无子节点:");
                //123##45###67##89###
                /*
                        1
                       / \
                      2   6
                     / \ / \
                    3  4 7  8
                      /    /
                     5    9
                 */
                String dataString = input.nextLine();
                char[] chars = dataString.toCharArray();
                LinkedList<Character> list = new LinkedList<Character>();
                for (int i = 0; i < chars.length; i++){
                    list.add(chars[i]);
                }
                myBinaryTree.root = myBinaryTree.createBinaryTree(list);
                System.out.println("二叉树创建完成!");
            }
            else if(num == 2){
                System.out.println("递归先序遍历序列为:");
                myBinaryTree.preOrderTraverse(myBinaryTree.root);
            }
            else if(num == 3){
                System.out.println("递归中序遍历序列为:");
                myBinaryTree.inOrderTraverse(myBinaryTree.root);
            }
            else if(num == 4){
                System.out.println("递归后序遍历序列为:");
                myBinaryTree.postOrderTraverse(myBinaryTree.root);
            }           
            else if(num == 5){
                System.out.println("非递归先序遍历序列为:");
                myBinaryTree.preOrderS(myBinaryTree.root);
            }           
            else if(num == 6){
                System.out.println("非递归中序遍历序列为:");
                myBinaryTree.inOrderS(myBinaryTree.root);
            }           
            else if(num == 7){
                System.out.println("非递归后序遍历序列为:");
                myBinaryTree.postOrderS(myBinaryTree.root);
            }
            ShowMenu();
            num = input.nextInt();
        }
        input.close();
    }
}
