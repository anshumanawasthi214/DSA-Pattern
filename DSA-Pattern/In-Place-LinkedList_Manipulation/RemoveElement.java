public class RemoveElement {
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

    public static ListNode removeElements(ListNode head,int data){
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode curr=dummy;
        while(curr.next!=null){
            if(curr.next.val==data){
                curr.next=curr.next.next;
            }
            else{
                curr=curr.next;
            }
           
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next = new ListNode(7);

        int valToRemove = 7;
        ListNode modifiedHead = removeElements(head, valToRemove);

        // Print modified list
        printList(modifiedHead);
    }
}
