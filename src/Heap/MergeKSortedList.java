package Heap;

import java.util.PriorityQueue;

/**
 * @author ksharma
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>(lists.length,(a,b)->Integer.compare(a.val,b.val));
        for(ListNode list:lists){
            if(list!=null){
                pq.offer(list);
            }
        }
        ListNode result=null;
        ListNode resultHead=null;
        while(!pq.isEmpty()){
            ListNode temp=pq.poll();
            if(result==null){
                result=new ListNode(temp.val);
                resultHead=result;
            }else{
                result.next=new ListNode(temp.val);
                result=result.next;
            }
            if(temp.next!=null){
                pq.offer(temp.next);
            }
        }
        return resultHead;
    }
    public static void main(String []args){
        MergeKSortedList ms=new MergeKSortedList();
        ListNode l1=new ListNode(1);
        ListNode head1=l1;
        l1.next=new ListNode(4);
        l1=l1.next;
        l1.next=new ListNode(5);

        ListNode l2=new ListNode(1);
        ListNode head2=l2;
        l2.next=new ListNode(3);
        l2=l2.next;
        l2.next=new ListNode(4);

        ListNode l3=new ListNode(2);
        ListNode head3=l3;
        l3.next=new ListNode(6);

        ListNode[]lists={head1,head2,head3};

        ListNode result=ms.mergeKLists(lists);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}
