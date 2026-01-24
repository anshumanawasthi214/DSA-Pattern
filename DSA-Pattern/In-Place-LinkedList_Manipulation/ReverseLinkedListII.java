import java.util.List;

public class ReverseLinkedListII {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public static ListNode reverseBetween(ListNode head, int left,int right){
        if(head==null || head.next==null)return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode p=dummy;
        ListNode c=head;
        int counter=0;
        while(counter<left-1){
                p=c;
                c=c.next;
                counter++;
        }
        ListNode prev=null;
        ListNode curr=c;
        counter=0;
        while(counter<(right-left+1)){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            counter++;
        }
        p.next=prev;
        c.next=curr;
        
       return dummy.next;
            
    }
   
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int left = 2;
        int right = 4;
        System.out.print("Before : ");
        printList(head);
        ListNode result = reverseBetween(head, left, right);
        System.out.print("After  : ");
        printList(result);
    }
}
