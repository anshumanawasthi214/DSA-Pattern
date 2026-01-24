public class RemoveDuplicateFromSortedList {
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

    public static ListNode deleteDuplicates(ListNode head){
        if(head==null || head.next==null)return head;
       
        ListNode curr=head;
        while(curr.next!=null ){
          if(curr.val==curr.next.val){
            curr.next=curr.next.next;
          }
          else{
            curr=curr.next;
          }
        }
       
        return head;
}
    
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode modifiedHead = deleteDuplicates(head);

        // Print modified list
        printList(modifiedHead);
    }
}
