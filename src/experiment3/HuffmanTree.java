package experiment3;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class HuffmanTree {
    public treeNode root;

    public treeNode createHuffmanTree(ArrayList<treeNode> nodes) {
		// 只要nodes数组中还有2个以上的节点
		while (nodes.size() > 1) {
			Collections.sort(nodes);//将结点数组降序排序
            // for (treeNode treeNode : nodes) {
            //     System.out.print(treeNode.data+" "+ treeNode.weight+"\t");
            // }
            // System.out.println();
			//获取权值最小的两个节点
			treeNode left = nodes.get(nodes.size()-1);
			treeNode right = nodes.get(nodes.size()-2);
			
			//生成新节点，新节点的权值为两个子节点的权值之和
			treeNode parent = new treeNode(null, left.weight + right.weight);
			
			//让新节点作为两个权值最小节点的父节点
			parent.left = left;
			parent.right = right;
			
			//删除权值最小的两个节点
			nodes.remove(nodes.size()-1);
			nodes.remove(nodes.size()-1);
			
			//将新节点加入到集合中
			nodes.add(parent);
		}
		
		return nodes.get(0);
	}

    //广度优先遍历来对HuffmanTree进行编码
	public ArrayList<treeNode> breadthFirst(treeNode root){
		Queue<treeNode> queue = new ArrayDeque<treeNode>();
		ArrayList<treeNode> list = new ArrayList<treeNode>();
		
		if(root!=null){
			//将根元素加入队列
			queue.offer(root);
            root.left.setCode(root.getCode() + "0");
            root.right.setCode(root.getCode() + "1");
		}
		
		while(!queue.isEmpty()){
			//将该队列的队头元素加入到list中
			treeNode p = queue.poll();
			list.add(p);
			
			//如果左子节点不为null，将它加入到队列
			if(p.left != null){
				queue.offer(p.left);
                p.left.setCode(p.getCode()+"0");
			}
			
			//如果右子节点不为null，将它加入到队列
			if(p.right != null){
				queue.offer(p.right);
                p.right.setCode(p.getCode()+"1");
			}
		}
        return list;
    }

    public void printHuffmanCode(ArrayList<treeNode> list){
        for (int i = 0; i < list.size();i++){
            treeNode p = list.get(i);
            if(p.data != null)
                System.out.println("结点值为:"+p.data+"\t权值为:"+p.weight+"\t编码为:"+p.code);
        }
    }
}
