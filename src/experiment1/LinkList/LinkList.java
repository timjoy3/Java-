package experiment1.LinkList;

//链表类
public class LinkList{
    //定义头结点
    public Node head = null;
    
    //向链表中添加结点
    public void addNode(int data){
        Node newNode = new Node(data);
        //没有头结点则将该结点设为头结点
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        //从头结点开始遍历到链表尾部
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;//添加结点到链表末尾
    }
    
    //删除值为delData的第一个结点
    public boolean deleteNodeFirst(int delData){
        //判断链表是否为空
        if (head == null){
            System.out.println("链表为空，无法删除");
            return false;
        }
        //判断删除的是头结点
        if (head.data == delData){
            head = head.next;//将结点的下一个结点作为头结点
            return true;
        }

        Node preNode = head;
        Node curNode = preNode.next;

        //遍历整个链表
        while(curNode != null){
            if(curNode.data != delData){//寻找待删除结点
                //当前结点和前结点同时向后移
                preNode = curNode;
                curNode = preNode.next;
            }
            else {
                preNode.next = curNode.next;//待删除结点的前结点指向待删除结点的后结点
                return true;
            }
        }
        //遍历链表未找到结点
        System.out.println("链表中不存在值为 "+delData+" 的结点,删除失败");
        return false;
    }

    //删除值为delData的所有结点
    public boolean deleteNodeAll(int delData){
        //判断链表是否为空
        if (head == null){
            System.out.println("链表为空，无法删除");
            return false;
        }
        System.out.println("头结点数据为:"+head.data);

        boolean find = false;

        //判断删除的是头结点,保证找到头结点
        while (head.data == delData){
            find = true;
            head = head.next;//将头结点的下一个结点作为头结点
        }     

        Node preNode = head;
        Node curNode = preNode.next;
        
        while(curNode != null){
            //找到待删除结点
            System.out.println("当前结点为:"+curNode.data);
            if(curNode.data == delData) {
                find = true;
                preNode.next = curNode.next;//待删除结点的前结点指向待删除结点的后结点 
            }
            else preNode = curNode;
            curNode = curNode.next;
        }
        if (find) return true;
        else {
            System.out.println("链表中不存在值为 "+delData+" 的结点,删除失败");
            return false;
        }   
    }

    /*链表结点排序,并返回排序后的头结点
    选择排序算法,即每次都选出未排序结点中最小的结点，与第一个未排序结点交换*/
    public Node linkSort(){
        Node curNode = head;
        while(curNode != null){
            Node nextNode = curNode.next;
            while(nextNode != null){
                if(curNode.data > nextNode.data){//将小的值移到前面
                    int temp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    //将链表输出
   public void printList(){
        Node curNode = head;
        while(curNode !=null){
            System.out.print(curNode.data+" ");
            curNode = curNode.next;
        }
        System.out.println("\n");
   }    
} 