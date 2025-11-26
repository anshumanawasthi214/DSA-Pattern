public class LinkedListCycle_II {
     static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node cycleDetection(Node head){
          Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                fast=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                    
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        
       
        // Creating nodes
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        // Linking nodes like 1 -> 2 -> 3 -> 4 -> 5
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Creating a cycle: last node pointing back to third
        fifth.next = third;   // <- CYCLE created here

        Node n=cycleDetection(head);
        System.out.println("This is the starting point of the cycle: "+n.data);
    }
}
