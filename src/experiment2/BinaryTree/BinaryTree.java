package experiment2.BinaryTree;
import java.util.LinkedList;
import java.util.Stack;
//定义树结点
class treeNode {
    treeNode left = null;//左子树
    treeNode right = null;//右子树
    char data;//结点数据
    public treeNode(){}
    public treeNode(char data){
        this.data = data;
    }
}

public class BinaryTree {
    treeNode root;
    //创建二叉树
    
    public treeNode createBinaryTree(LinkedList<Character> list) {
        char data = list.getFirst().charValue();
        if (data != '#') {
            treeNode T = new treeNode();
            T.data = data;
            list.removeFirst();
            T.left = createBinaryTree(list);
            T.right = createBinaryTree(list);
            return T;
        }
        else {
            list.removeFirst();
            return null;
        }

    }

    //先序遍历二叉树
    public void preOrderTraverse(treeNode root){
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }
    //中序遍历二叉树
    public void inOrderTraverse(treeNode root){
        if(root == null)
            return;
        inOrderTraverse(root.left);
        System.out.print(root.data+" ");
        inOrderTraverse(root.right);
    }
    //后序遍历二叉树
    public void postOrderTraverse(treeNode root){
        if(root == null)
            return;
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.data+" ");
    }

    //先序遍历——非递归
    void preOrderS(treeNode root) {
        Stack<treeNode> stack = new Stack<treeNode>();
    	treeNode p = root;
    	while (p != null || !stack.empty()) {
    		while (p != null) {
                System.out.print(p.data+" ");
    			stack.push(p);
    			p = p.left;
    		}

    		if (!stack.empty()) {
    			p = stack.peek();
    			stack.pop();
    			p = p.right;
    		}
    	}
    }

    //中序
    void inOrderS(treeNode root) {
    	Stack<treeNode> stack = new Stack<treeNode>();
    	treeNode p = root;
    	while (p != null || !stack.empty()) {
    		while (p != null) {
    			stack.push(p);
    			p = p.left;
    		}
    		if (!stack.empty()) {
    			p = stack.peek();
    			stack.pop();
                System.out.print(p.data+" ");
    			p = p.right;
    		}
    	}
    }

    //后序
    void postOrderS(treeNode root) {
    	treeNode p = root, r = null;
    	Stack<treeNode> stack = new Stack<treeNode>();
    	while (p != null || !stack.empty()) {
    		if (p != null) {//走到最左边
    			stack.push(p);
    			p = p.left;
    		}
    		else {
    			p = stack.peek();
    			if (p.right != null && p.right != r)//右子树存在，未被访问
    				p = p.right;
    			else {
    				stack.pop();
    				System.out.print(p.data+" ");
    				r = p;//记录最近访问过的节点
    				p = null;//节点访问完后，重置p指针
    			}
    		}
    	}
    }
}
