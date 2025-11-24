import java.util.HashSet;
import java.util.Set;

class Node{
        public int val;
    public Node left;
    public Node right;
    public Node parent;
     Node(int val) {
        this.val = val;
    }
}
public class LowestCommonAncestorOfABinaryTreeIII {
   

    // public static Node lowestCommonAncestor(Node p, Node q) { Approach 1 : 
                                                    // Time Complexity: O(n)
                                                    // Space Complexity: O(n)
    //     Set<Integer> s=new HashSet<>();
    //     while(p!=null){
    //         s.add(p.val);
    //         p=p.parent;
    //     }

    //     while(q!=null){
    //         if(s.contains(q.val)){
    //             return q;
    //         }
    //         else{
    //             q=q.parent;
    //         }
    //     }
    //     return null;
    // }

     public static Node lowestCommonAncestor(Node p, Node q) {// Approach 2 Optimized Space Complexity                     Time Complexity : O(n)
                                        //Space Complexity: O(1)
       Node temp1=p;
       Node temp2=q;
       while(temp1!=temp2){
            temp1=temp1==null?q:temp1.parent;
            temp2=temp2==null?p:temp2.parent;
           
       }
       return temp1;
    }
    public static void main(String[] args) {
         // Create tree manually
        //        3
        //       / \
        //      5   1
        //     / \  / \
        //    6  2 0  8
        //      / \
        //     7   4

        Node root = new Node(3);

        root.left = new Node(5);
        root.right = new Node(1);
        root.left.parent = root;
        root.right.parent = root;

        root.left.left = new Node(6);
        root.left.left.parent = root.left;

        root.left.right = new Node(2);
        root.left.right.parent = root.left;

        root.left.right.left = new Node(7);
        root.left.right.left.parent = root.left.right;

        root.left.right.right = new Node(4);
        root.left.right.right.parent = root.left.right;

        root.right.left = new Node(0);
        root.right.left.parent = root.right;

        root.right.right = new Node(8);
        root.right.right.parent = root.right;

        // Choose sample nodes for LCA
        Node p = root.left;               // Node 5
        Node q = root.left.right.right;   // Node 4

        Node ans=lowestCommonAncestor(p,q);

         System.out.println("LCA of " + p.val + " and " + q.val + " = " + ans.val);

        
    }
}
