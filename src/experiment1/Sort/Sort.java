package experiment1.Sort;
import experiment1.LinkList.*;

/*使用单链表实现几种排序算法 */
public class Sort {
    //插入排序
    public void insertSort(Node node) {
        //链表不为空才进行排序
        if (node.next != null) {
            Node p,curr,pre,next;
            curr = node.next;
            node.next = null;
            while (curr != null) {
                pre = node;
                next = pre.next;
                while (next != null && next.data < curr.data) {
                    pre = next;
                    next = next.next;
                }
                p = curr.next;
                curr.next = pre.next;
                pre.next = curr;
                curr = p;
            }
        }
    }
    
    //冒泡排序
    public void bubbleSort(Node node) {
    	Node p,q;
        Node tail = null;

    	while ((node.next) != tail){//如果第2个数都确定了,那么第1个数也已经确定
		    p = node;
		    q = node.next;
            if(p.data > q.data){//先处理最前面两个数
                node = q;
                p.next = q.next;
                node.next = p;
                p = node;
                q = node.next;
            }
		    while (q.next != tail){//while循环结束后,调整已经完毕
            
		    	if ((q.data) > (q.next.data))
		    	{
		    		p.next = q.next;
		    		q.next = q.next.next;
		    		p.next.next = q;//整体思路为先判断data大小,满足后结点小时,让
		    		q = p.next;//结点连接完成后,将q返回至新的首结点
		    	}
		    	q = q.next;//p,q前往下一结点继续判断
		    	p = p.next;
		    }
		    tail = q;//将结束指针往前一格
	    }
    }

    //快速排序所需的交换函数
    public void swap(Node p, Node q) {
    	int tmp = p.data;
    	p.data = q.data;
    	q.data = tmp;
    }
    //快速排序
    public void quickSort(Node head, Node tail) {
    	if (head == tail || head == null || head == tail.next)
    		return;
    	Node p, q, pre;
    	p = q = pre = head;
    	while (q != tail) {
    		q = q.next;
    		if (q.data < head.data) {
    			pre = p;
    			p = p.next;
    			swap(p, q);
    		}
    	}
    	swap(head, p);
    	quickSort(head, pre);
    	quickSort(p.next, tail);
    }

    //归并排序切割 
    public Node cut(Node head) {
    	Node p = head;
    	Node q = head;
    	Node second_head;
    	while (q!=null && q.next!=null) {//p每移动一次，q移动两次,从而实现分割
    		q = q.next;
    		if (q.next!=null) {
    			p = p.next;
    			q = q.next;
    		}
    	}
    	second_head = p.next;
    	p.next = null;
    	return second_head;
    }
    //归并排序合并 
    public Node merge(Node head1, Node head2) {
    	Node p1 = head1, p2 = head2, head;
        //得到头节点的指向
        if (head1.data < head2.data) {
            head = head1;
            p1 = p1.next;
        } else {
            head = head2;
            p2 = p2.next;
        }
    
        Node p = head;
        //比较链表中的值
        while (p1 != null && p2 != null) {
        
            if (p1.data <= p2.data) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        //第二条链表空了
        if (p1 != null) {
            p.next = p1;
        }
        //第一条链表空了
        if (p2 != null) {
            p.next = p2;
        }
        return head;
    }
    //归并排序 
    public Node mergeSort(Node head) {
        //采用归并排序
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = cut(head);
        //合并
        return merge(mergeSort(head), mergeSort(mid));//采用递归进行分治
    }
    //堆排序
    public void DumpSort(int [] list) {
        for (int i = list.length / 2 - 1; i >= 0; i--) {
            adjust(list, i, list.length);
        }

        for (int j = list.length - 1; j > 0; j--) {
            swap(list, 0, j);//每次找到最大值时调到数组末尾
            adjust(list, 0, j);//寻找最大值
        }
    }

    public void adjust(int [] list, int i, int length) {
        int temp = list[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && list[k] < list[k + 1]) {
                k++;
            }

            if (list[k] > temp) {
                list[i] = list[k];
                i = k;
            }
        }
        list[i] = temp;
    }

    public void swap(int [] list, int a, int b) {
        int t = list[a];
        list[a] = list[b];
        list[b] = t;
    }
}