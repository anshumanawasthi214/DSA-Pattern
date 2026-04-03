import java.util.*;
public class FIndKthLargestIntegerInStringArray {
    public static String kthLargestNumberSortingApproach(String [] nums,int k){
        //TC:O(nlogn) SC:O(1)
        Arrays.sort(nums,(a,b)->{
            if(a.length()==b.length()){
                return a.compareTo(b);
            }
            return a.length()-b.length();
        });

        return nums[nums.length-k];

    }

    public static String kthLargestNumberPriorityQueueApproach(String nums[],int k){//TC:O(nlogk) SC:O(k)

        PriorityQueue<String> heap=new PriorityQueue<>(
            (a,b)->{
                if(a.length()==b.length()){
                return a.compareTo(b);
            }
            return a.length()-b.length();
            }
        );

        for(String s:nums){
            heap.add(s);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.peek();
    }
    public static void main(String[] args) {
        String[] nums = {"3", "6", "7", "10"};
        int k = 4;
        System.out.println(kthLargestNumberSortingApproach(nums, k));
        System.out.println(kthLargestNumberPriorityQueueApproach(nums, k));
    }
}
