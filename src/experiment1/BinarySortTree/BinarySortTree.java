package experiment1.BinarySortTree;
/*
建立有序表，通过有序表来构造二叉排序树
构造方法：使用二分法，取有序数组的中间结点作为根节点，左边部分作为左子树，右边部分作为右子树
 */
//定义树结点
class treeNode {
    treeNode left = null;//左子树
    treeNode right = null;//右子树
    int data;//结点数据
    public treeNode(int data){
        this.data = data;

    }
}
public class BinarySortTree {
    treeNode root = null;

    //创建二叉排序树
    public treeNode createBST(Integer[] data) {
		if (data == null || data.length == 0) {
			return null;
		}
        //创建结点数组存储数结点
        int len = data.length;
		treeNode[] nodes = new treeNode[len];
		for (int i = 0; i < len; i++) {
			nodes[i] = new treeNode(data[i]);
		}
		return createBSTNode(nodes, 0, data.length - 1);
	}
    //递归方式创建二叉排序树
    public treeNode createBSTNode(treeNode[] nodes, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		if (start == end) {
			return nodes[mid];
		}
		treeNode root = nodes[mid];
		root.left = createBSTNode(nodes, start, mid - 1);//插入算法
		root.right = createBSTNode(nodes, mid + 1, end);
		return root;
	}
    //删除结点
    public void delBSTNode(treeNode root, int key) { ///二叉排序树删除节点
        // node* p = T, * f = null, * q, * s;
        treeNode p = root;
        treeNode f = null;
        treeNode q,s;
        while (p!=null) {
            if (p.data == key) break; //找到关键字为key的结点
            f = p;//记下关键字key节点的父节点
            p = (key < p.data) ? p.left : p.right;//分别在p的左、右子树中查找
        }
        if (p==null) return;//二叉排序树中无关键字为key的结点
        if (p.left == null && p.right == null) { //p没有左右子树
            if (p == root) root = null;//删除的是根节点
            else if (p == f.left)
                f.left = null;
            else
                f.right = null;
            //free(p);
        }
        else if (p.left == null && p.right != null) { //p无左子树有右子树
            if (f.left == p)
                f.left = p.right; //将p的右子树链接到其父结点的左链上
            else
                f.right = p.right; //将p的右子树链接到其父结点的右链上
            // free(p);
        }
        else if (p.right == null && p.left != null) { //p有左子树无右子树
            if (f.left == p)
                f.left = p.left; //将p的左子树链接到其父结点的左链上
            else
                f.right = p.left; //将p的左子树链接到其父结点的右链上
            // free(p);
        }
        else if (p.left != null && p.right != null) { //p既有左子树又有右子树
            q = p;
            s = p.left;//转左
            while (s.right!=null) { //然后向右到尽头
                q = s;
                s = s.right;//s指向被删节点的“前驱”(中序前驱)
            }
            p.data = s.data;//以p的中序前趋结点s代替p（即把s的数据复制到p中）
            if (q != p) q.right = s.left;//重接q的右子树
            else q.left = s.left;//重接q的左子树。
            // free(s);
        }
    }

    public boolean binarySearch(treeNode root,treeNode p,int searchData) {
        if (root == null){
            p = null;
            return false;
        }
        //根据二叉排序树的性质进行查找
        while (root != null) {
            p = root;
            if(searchData == root.data)
                return true;
            else if (searchData > root.data)
                root = root.right;
            else if (searchData < root.data)
                root = root.left;
        }
        return false;
    }
    //先序遍历二叉树
    public void PreOrderTraverse(treeNode root){
        if(root == null)
            return;
        System.out.print(root.data+" ");
        PreOrderTraverse(root.left);
        PreOrderTraverse(root.right);
    }
    //中序遍历二叉树
    public void InOrderTraverse(treeNode root){
        if(root == null)
            return;
        InOrderTraverse(root.left);
        System.out.print(root.data+" ");
        InOrderTraverse(root.right);
    }
}

