
public class CycleDetectionInALinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static void cycleDetection(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null  &&  fast.next!=null){
            slow=slow.next; 
            fast=fast.next.next;
            if(slow==fast){
                System.out.println("This linked list has a cycle in it : "+slow.data);
                return ;
            }
        }

        System.out.println("This Linked List doesn't have a cycle in it...");

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


        cycleDetection(head);

    
    }
}
