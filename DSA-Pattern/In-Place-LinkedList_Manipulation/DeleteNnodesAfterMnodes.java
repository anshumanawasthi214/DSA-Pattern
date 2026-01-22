public class DeleteNnodesAfterMnodes {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println("null");
    }

    public static ListNode deleteNnodesAfterMnodes(ListNode head,int M,int N){
        //TC:O(n) SC:O(1)
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            for(int i=0;i<M && curr!=null;i++){
                prev=curr;
                curr=curr.next;
            }
            for(int i=0;i<N && curr!=null ;i++){
                curr=curr.next;
            }
            prev.next=curr;
        }
        return head;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        int M = 2; // Number of nodes to keep
        int N = 1; // Number of nodes to delete

        System.out.println("Original Linked List:");
        printList(head);

        ListNode modifiedHead = deleteNnodesAfterMnodes(head, M, N);

        System.out.println("Modified Linked List:");
        printList(modifiedHead);
    }
}
