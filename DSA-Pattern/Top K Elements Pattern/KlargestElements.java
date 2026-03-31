import java.util.PriorityQueue;

public class KlargestElements{
    public static void main(String args[]){// Time Complexity: O(nlogk) and Space Complexity: O(k)
        int arr[]={3,51,9,4,2,12,15};
        int k=3;

        PriorityQueue<Integer> heap=new PriorityQueue<>();

        for(int i=0;i<k;i++){
            heap.add(arr[i]);   
        }
        
        for(int i=k;i<arr.length;i++){
            heap.add(arr[i]);
            heap.remove();
        }
        System.out.println(heap.toString());

    }
}