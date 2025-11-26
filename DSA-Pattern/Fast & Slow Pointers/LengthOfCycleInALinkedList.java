
public class LengthOfCycleInALinkedList {
    static class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }

    }

    public static void calculateLength(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){ //cycle detect
                 int length=1;
                 slow=slow.next;//move only slow
                while(slow!=fast){
                     slow=slow.next;
                     length++;
                }
                System.out.println("Length of Cycle is : "+length);
                return ;
            }
        }
        
       
    }

    public static void main(String[] args) {
        
        // Create nodes (at least 7)
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        // Link nodes normally
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        // Create cycle of length 7 (n7 → n1 OR any inside 7 nodes)
        n7.next = head;  // cycle created back to head

        calculateLength(head);
    }
}
