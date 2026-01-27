public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static ListNode reorderList(ListNode head){
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        ListNode slow=head;
        ListNode fast=head;
     
            while(fast.next!=null && fast.next.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }

            fast=slow.next;
            fast=reverse(fast);
            slow.next=null;
            slow=head;
            while(slow!=null && fast!=null){
                ListNode temps=slow.next;
                slow.next=fast;
                ListNode tempf=fast.next;
                fast.next=temps;
                slow=temps;
                fast=tempf;
            }
            return head;


    }
    public static ListNode reverse(ListNode fast){
        ListNode curr=fast;
        ListNode prev=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;

    }

    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        printList(head);
        reorderList(head);
        printList(head);

    }
}
