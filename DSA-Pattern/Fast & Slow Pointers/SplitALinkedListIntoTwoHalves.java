public class SplitALinkedListIntoTwoHalves{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static void splitList(Node head){
          Node fast=head.next;
        Node slow=head;
        while(fast!=head && fast.next!=head){
            slow=slow.next;
            fast=fast.next;
            if(fast.next!=head){
                fast=fast.next;
            }
        }
        fast.next=slow.next;
        slow.next=head;
        System.out.println("The fist List's Head is : "+head.data+" and second List Head is : "+fast.next.data);
    }

    public static void main(String[] args) {

        Node head=new Node(1);

        Node n1=new Node(2);
        Node n2=new Node(3);
        Node n3=new Node(4);
        Node n4=new Node(5);

        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=head; //Circular Linked List

        splitList(head);
        
        
    }
}