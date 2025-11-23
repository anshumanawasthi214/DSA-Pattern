
public class RemoveNthNodeFromEndOfList{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node deleteNthNode(Node root,int pos){
        if(root==null || pos<=0)return root;
        
        Node temp=root;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        if(pos==size){
            root=root.next;
            return root;
        }
        
        temp=root;
        int deletePos=(size-pos);

        if(deletePos>size || deletePos<=0)return root;
        int i=1;
        while(i<deletePos){
            temp=temp.next;
            i++;
        }
        if(temp.next.next==null){
            temp.next=null;
        }else{
        temp.next=temp.next.next;
        }
       
        return root;
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        Node n=root;
        for(int i=2;i<=5;i++){
            Node newNode=new Node(i);
            n.next=newNode;
            n=newNode;
        }

        Node temp=root;
        while(temp!=null){
                System.out.print(temp.data+" ");
                System.out.print("-> ");
                temp=temp.next;
        }
          System.out.println("X");
        System.out.println();
        
        int position=1;

       temp= deleteNthNode(root,position);
          while(temp!=null){
                System.out.print(temp.data+" ");
                System.out.print("-> ");
                temp=temp.next;
        }
        System.out.println("X");


    }
}