import java.util.*;

public class KthLargestElementInStream{
    Queue<Integer> minHeap;
    int kth;
    public KthLargestElementInStream(int k, int[] nums) {
        minHeap=new PriorityQueue<>();
        kth=k;
        for(int i=0;i<nums.length && i<k;i++){
            minHeap.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(minHeap.peek()<nums[i]){
                minHeap.remove();
                minHeap.add(nums[i]);
            }
        }
    }
    public int add(int val){
        if(minHeap.isEmpty()){
            minHeap.add(val);
        }else{
            if(minHeap.size()<kth){
                minHeap.add(val);
            }
            else if(minHeap.peek()<=val){
                minHeap.remove();
                minHeap.add(val);
            }
        }
        return minHeap.peek();
    }
    public static void main(String args[]){
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargestElementInStream kthLargest = new KthLargestElementInStream(k, nums);
        System.out.println("Added 3: returns: "+kthLargest.add(3));   // returns 4
        System.out.println("Added 5: returns: "+kthLargest.add(5));   // returns 5
        System.out.println("Added 10: returns: "+kthLargest.add(10)); // returns 5
        System.out.println("Added 9: returns: "+kthLargest.add(9));   // returns 8
        System.out.println("Added 4: returns: "+kthLargest.add(4));   // returns 8

    
    }
}