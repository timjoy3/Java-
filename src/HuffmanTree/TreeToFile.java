package HuffmanTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TreeToFile {
    /**
     * 将建好的哈夫曼树存入文件 
     * @param list:存放结点数组
     * */
    public void huffmanTreeOutput(ArrayList<DrawNode> list,String filePath){
        try {
            File file = new File(filePath); 
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);//将结点对象链表写入文件中
			System.out.println("Done");
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
        }
    }

    /**
     * 从文件中读取哈夫曼树
     * @param  path 读取哈夫曼树的文件路径
     * @return 返回哈夫曼树的结点数组
     */
    @SuppressWarnings("unchecked")
    public ArrayList<DrawNode> huffmanTreeInput(String path) throws IOException, ClassNotFoundException{
        ArrayList<DrawNode> NodeList;
        File file = new File(path); 
        FileInputStream fis = new FileInputStream(file); 
        ObjectInputStream ois = new ObjectInputStream(fis); 
        NodeList = (ArrayList<DrawNode>)ois.readObject();//从文件中读取结点对象
        for (DrawNode drawNode : NodeList) {
            this.displayTreeNode(drawNode);
        }
        fis.close(); 
        ois.close(); 
        return NodeList;
    }

    public void displayTreeNode(DrawNode node){
        System.out.println(node.getData()+"\t"+node.getWeight()+"\t"+node.getCode());
    }
}
