package experiment2.Stack;

import experiment1.LinkList.Node;
public class LinkStack {
    public Node top;
    public Node base;
    public int count;

    //创建链栈
    public void initLinkStack(){
        Node elem = new Node() ;           //开辟一个元素的空间作为栈底
        base = elem ;                            //top指针和base指针初始化
        top =  elem ;
        // base.data = null ;
    }


        //入栈
    public void pushLinkStack(int indata){
        Node elem = new Node() ;           // 入栈元素分配空间
        elem.data =  indata;                        // 将元素放入
        elem.next = top ;                        // 元素指针指向当前top所指元素
        top = elem ;                             // 修改top指针
    }

    //出栈
    public int popLinkStack(){
        if(base == top){
            System.out.println("出栈失败，栈为空!");
            return -1;
        }
        int outData = top.data ;                   //取出对象的值
        top = top.next ;                          //修改top指针
        return outData;                              //返回元素
    }

	/**栈的遍历：输出栈*/
	void printLinkStack() {
		if(base == top){                        //若栈空
            System.out.println("输出失败，栈为空!");
        }
		else{
            Node flag = top ;
            System.out.print("栈中元素为:");
            while(flag != base){
                System.out.print(flag.data+" ");
                flag = flag.next ;
            }
        }
		System.out.println();
	}
}
