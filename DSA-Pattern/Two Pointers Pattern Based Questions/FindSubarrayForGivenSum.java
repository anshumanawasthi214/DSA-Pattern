import java.util.*;

public class FindSubarrayForGivenSum {
    public static void helper(int[] nums,int target) {
            HashMap<Integer,Integer> hmap=new HashMap<>();
            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
                if(sum==target){
                    for(int j=0;j<=i;j++){
                        System.out.print(nums[j]+" ");
                    }
                    System.out.println();
                }
                if(hmap.containsKey(sum-target)){
                    int startIndex=hmap.get(sum-target)+1;
                    for(int j=startIndex;j<=i;j++){
                        System.out.print(nums[j]+" ");
                    }
                    System.out.println();
                }
                hmap.put(sum,i);
            }
    }
    public static void main(String[] args) {
        int arr[]={3,4,-7,1,3,3,1,-4};

        int target=7;
        helper(arr,target);
    }
}
