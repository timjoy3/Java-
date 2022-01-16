package experiment3;

import java.util.ArrayList;
import java.util.Scanner;

public class TestHuffmanTree {
    public static void main(String[] args) {
        System.out.println("请输入数据和对应的权值(按q退出)");
        Scanner input = new Scanner(System.in);
        String data_node = input.nextLine();
        ArrayList<treeNode> nodes = new ArrayList<treeNode>();
        HuffmanTree myHuffmanTree = new HuffmanTree();
        while (!data_node.equals("q")){
            String [] dataList = data_node.split(" ");
            String data = dataList[0];
            int weight = Integer.parseInt(dataList[1]);
            treeNode node = new treeNode(data, weight);
            nodes.add(node);
            data_node = input.nextLine();
        }
        //创建哈夫曼树
        myHuffmanTree.root = myHuffmanTree.createHuffmanTree(nodes);
        // System.out.println("根节点权重:"+myHuffmanTree.root.weight);
        ArrayList<treeNode> list= new ArrayList<treeNode>();
        //利用广度优先遍历进行哈夫曼编码
        list = myHuffmanTree.breadthFirst(myHuffmanTree.root);
        //打印哈夫曼编码
        myHuffmanTree.printHuffmanCode(list);

        input.close();
    }
}
