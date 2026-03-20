import java.util.PriorityQueue;

public class LongestHappyString{
    //Bruteforce Approach TC: O(a+b+c) SC: O(a+b+c)
    public static String longestDiverseString(int a, int b, int c){
        //Bruteforce Approach
        int count_a=0;
        int count_b=0;
        int count_c=0;
        StringBuilder result=new StringBuilder();
        while(true){
            if(a>0 && ((a>=b && a>=c && count_a<2) || (count_b==2 && b>=a && a>=c) || (count_c==2 && c>=a && a>=b))){
                result.append('a');
                a--;
                count_a++;
                count_b=0;
                count_c=0;
            }
            else if(b>0 && ((b>=a && b>=c && count_b<2) || (count_a==2 && a>=b && b>=c) || (count_c==2 && c>=b &&  b>=a))){
                result.append('b');
                b--;
                count_b++;
                count_a=0;
                count_c=0;
            }
            else if(c>0 && ((c>=a && c>=b && count_c<2) || (count_b==2 && b>=c && c>=a) || (count_a==2 && a>=c && c>=b))){
                result.append('c');
                c--;
                count_c++;
                count_a=0;
                count_b=0;
            }
            else{
                break;
            }
        }
        return result.toString();

    }
    static class Node{
        char key;
        int val;
        Node(char key,int val){
            this.key=key;
            this.val=val;
        }
    }

    //Optimal Approach TC: O(a+b+c) SC: O(1)
    public static String longestDiverseStringII(int a, int b, int c){
        PriorityQueue<Node> heap=new PriorityQueue<>((x,y)-> y.val-x.val);

        if(a>0){
            heap.add(new Node('a',a));
        }
        if(b>0){
            heap.add(new Node('b',b));
        }
        if(c>0){
            heap.add(new Node('c',c));
        }
        StringBuilder sb=new StringBuilder();
        while(!heap.isEmpty()){
            Node node=heap.poll();
            char key=node.key;
            int value=node.val;

            if(sb.length()>=2 && sb.charAt(sb.length()-1)==key && sb.charAt(sb.length()-2)==key){
                if(heap.isEmpty()){
                    break;
                }
                Node temp=heap.poll();
                char ch=temp.key;
                int v=temp.val;

                sb.append(ch);
                v=v-1;
                if(v>0){
                    heap.add((new Node(ch, v)));
                }
              
                    heap.add(new Node(key,value));
                
            }
            else{
               
                sb.append(key);
                value=value-1;
                if(value>0){
                    heap.add(new Node(key,value));
                }
                
            }
           
        }
         return sb.toString();
    }

    public static void main(String[] args) {
        int a = 1, b = 1, c = 3;    
        System.out.println(longestDiverseString(a, b, c));
        System.out.println(longestDiverseStringII(a, b, c));

    }
}