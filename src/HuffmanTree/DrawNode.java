package HuffmanTree;

import java.io.Serializable;

// 可比较的二叉树结点类
public class DrawNode implements Comparable<DrawNode>,Serializable{
    
    private String data;//结点数据
    private int weight;//结点权重
    private String code;//哈夫曼编码
    
    // private DrawNode parent;//父结点
    private DrawNode left;//左子树
    private DrawNode right;//右子树
    public DrawNode() {}
    public DrawNode(String data,int weight) {
        this.data = data;
        this.weight = weight;
        this.code = "";
    }
    public DrawNode(String data, int weight,DrawNode left, DrawNode right) {
        this.data = data;
        this.weight = weight;
        this.code = "";
        this.left = left;
        this.right = right;
    }

    /*重写Comparable类的方法 */
    @Override
    public int compareTo(DrawNode o) {
        return o.weight - this.weight;//降序        
    }
    @Override
    public String toString() {
        return "DrawNode{" +
                "data=" + this.data +
                ", weight=" + this.weight +'}';
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DrawNode getLeft() {
        return left;
    }

    public void setLeft(DrawNode left) {
        this.left = left;
    }

    public DrawNode getRight() {
        return right;
    }

    public void setRight(DrawNode right) {
        this.right = right;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public String getCode(){
        return this.code;
    }

    public void setCode(String str){
        this.code = str;
    }
}
