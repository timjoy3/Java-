package HuffmanTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

/**
 * 构建哈夫曼树
 */
public class HuffmanTree {

    private DrawNode root;

    public HuffmanTree(){
    }

    public DrawNode getRoot(){
        return this.root;
    }

    public void setRoot(DrawNode root){
        this.root = root;
    }

    /*
    根据结点数组构建一颗哈夫曼树 
    */
    public void createHuffmanTree(ArrayList<DrawNode> nodes) {
		// 只要nodes数组中还有2个以上的节点
		while (nodes.size() > 1) {
			Collections.sort(nodes);//将结点数组降序排序
			DrawNode left = nodes.get(nodes.size()-1);
			DrawNode right = nodes.get(nodes.size()-2);
			
			//生成新节点，新节点的权值为两个子节点的权值之和
			DrawNode parent = new DrawNode(" ", left.getWeight() + right.getWeight());
			
			//让新节点作为两个权值最小节点的父节点
			parent.setLeft(left);
			parent.setRight(right);
			
			//删除权值最小的两个节点
			nodes.remove(nodes.size()-1);
			nodes.remove(nodes.size()-1);
			
			//将新节点加入到集合中
			nodes.add(parent);
		}
        this.setRoot(nodes.get(0));
	}

    /*
    广度优先遍历来对HuffmanTree进行编码
    */
	public ArrayList<DrawNode> breadthFirst(){
		Queue<DrawNode> queue = new ArrayDeque<>();
		ArrayList<DrawNode> list = new ArrayList<>();
		
		if(this.getRoot()!=null){
			//将根元素加入队列
			queue.offer(this.getRoot());
            this.getRoot().getLeft().setCode(this.getRoot().getCode() + "0");
            this.getRoot().getRight().setCode(this.getRoot().getCode() + "1");
		}
		
		while(!queue.isEmpty()){
			//将该队列的队头元素加入到list中
			DrawNode p = queue.poll();
			list.add(p);
			
			//如果左子节点不为null，将它加入到队列
			if(p.getLeft() != null){
				queue.offer(p.getLeft());
                p.getLeft().setCode(p.getCode()+"0");
			}
			
			//如果右子节点不为null，将它加入到队列
			if(p.getRight() != null){
				queue.offer(p.getRight());
                p.getRight().setCode(p.getCode()+"1");
			}
		}
        return list;
    }

    
    /**
     * 通过结点数组将哈夫曼树表示出来，方便画出来 
     * @param list:存放结点数组
     * */
    public ArrayList<String> drawHuffmanTree(ArrayList<DrawNode> list){
        ArrayList<String> messageList= new ArrayList<>();
        for (DrawNode p : list) {
            if (p.getLeft() != null) {
                String messageLeft = p.getData() + "_" + p.getWeight() + "->" + p.getLeft().getData() + "_" + p.getLeft().getWeight() + " [label=\"0\"];";
                messageList.add(messageLeft);
            }
            if (p.getRight() != null) {
                String messageRight = p.getData() + "_" + p.getWeight() + "->" + p.getRight().getData() + "_" + p.getRight().getWeight() + " [label=\"1\"];";
                messageList.add(messageRight);
            }
        }
        return messageList;
    }

    /**
    将哈夫曼树利用Graphviz画出来
    * @param messageList:存放符合Graphviz格式的表示图的字符串数组
    * @param runPath:图片保存的路径
    * @param dotPath:Graphviz.exe程序的路径
    */
    public void displayHuffmanTree(ArrayList<String> messageList,String runPath,String dotPath){
        GraphViz gViz=new GraphViz(runPath, dotPath);
        gViz.start_graph();
        for (String s : messageList) gViz.addln(s);
        gViz.end_graph();
        try {
            gViz.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
