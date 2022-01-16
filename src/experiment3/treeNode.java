package experiment3;

//实现一个可比较的结点类
public class treeNode implements Comparable<treeNode>{
    public String data;
    public int weight;//结点权重
    public treeNode parent, left, right;//父结点、左孩子、右孩子
    public String code;

    public treeNode(String data,int weight){
        this.data = data;
        this.weight = weight;
        this.code = "";
    }

    @Override
    public int compareTo(treeNode o) {
        return o.weight - this.weight;//降序        
    }
    @Override
    public String toString() {
        return "treeNode{" +
                "data=" + data +
                ", weight=" + weight +'}';
    }

    public String getCode(){
        return this.code;
    }

    public void setCode(String str){
        this.code = str;
    }

}
