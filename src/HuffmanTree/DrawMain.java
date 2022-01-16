package HuffmanTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 如何画一颗二叉树的示例程序
 */
public class DrawMain {

    public static void ShowMenu(){
        System.out.println();
        System.out.println("*************  请选择你要进行的操作 **************");
        System.out.println("*************  1.创 建 哈 夫 曼 树 **************");
        System.out.println("*************  2.编            码 **************");
        System.out.println("*************  3.译            码 **************");
        System.out.println("*************  0.退            出 **************");
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ShowMenu();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        HuffmanTree myHuffmanTree = new HuffmanTree();
        while(num != 0){
            if (num == 1){
                input.nextLine();
                System.out.println("请输入数据和对应的权值(按q退出)");
                String data_node = input.nextLine();
                ArrayList<DrawNode> nodes = new ArrayList<>();
                while (!data_node.equals("q")){
                    String [] dataList = data_node.split(" ");
                    String data = dataList[0];
                    int weight = Integer.parseInt(dataList[1]);
                    DrawNode node = new DrawNode(data, weight);
                    nodes.add(node);
                    data_node = input.nextLine();
                }
                //创建哈夫曼树
                myHuffmanTree.createHuffmanTree(nodes);        
            
                //利用广度优先遍历进行哈夫曼编码
                ArrayList<DrawNode> list = myHuffmanTree.breadthFirst();

                //画哈夫曼树
                String runPath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/";
                String dotPath = "C:/Program Files (x86)/Graphviz/bin/dot.exe";
                ArrayList<String> messageList = myHuffmanTree.drawHuffmanTree(list);
                myHuffmanTree.displayHuffmanTree(messageList,runPath,dotPath);

                //将哈夫曼树存入文件中
                TreeToFile myTreeToFile = new TreeToFile();
                String filePath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/hfmTree.txt";
                myTreeToFile.huffmanTreeOutput(list, filePath);
                // new ShowImage();

            }
            else if(num == 2){
                //从文件中读取哈夫曼树
                TreeToFile myTreeToFile = new TreeToFile();
                String filepath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/hfmTree.txt";
                ArrayList<DrawNode> list = myTreeToFile.huffmanTreeInput(filepath);

                //从文件中读取文本
                CodeToFile myCodeToFile = new CodeToFile();
                String textPath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/ToBeTran.txt";
                String text =  myCodeToFile.TextFromFile(textPath);
                System.out.println("文本:"+text);

                //对文本进行编码并将编码存入文件
                String codePath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/CodeFile.txt";
                DeCodeAndEncode myDeCodeAndEncode = new DeCodeAndEncode();
                String code = myDeCodeAndEncode.HuffmanEncode(list, text);
                myCodeToFile.HuffmanCodeToFile(code, codePath);
            }
            else if(num == 3){
                //译码
                //从文件中读取哈夫曼树
                TreeToFile myTreeToFile = new TreeToFile();
                String filepath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/hfmTree.txt";
                ArrayList<DrawNode> list = myTreeToFile.huffmanTreeInput(filepath);
                //获取哈夫曼编码
                CodeToFile myCodeToFile = new CodeToFile();
                String codePath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/CodeFile.txt";
                String codeAll =  myCodeToFile.TextFromFile(codePath);
                System.out.println("codeAll:"+codeAll);
                //进行译码
                DeCodeAndEncode myDeCodeAndEncode = new DeCodeAndEncode();
                String TextDecode = myDeCodeAndEncode.HuffmanDecode(list, codeAll);
                System.out.println("TextAll:"+TextDecode);
                String codepath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/CodePrint.txt";
                myCodeToFile.HuffmanCodeToFile(TextDecode, codepath);
            }
            ShowMenu();
            num = input.nextInt();
        }
        input.close();
    }
}
