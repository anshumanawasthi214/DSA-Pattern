import java.util.Arrays;

public class CountPairsWhoseSumIsLessThanTarget {
    public static void helper(int nums[],int target){
        Arrays.sort(nums);
       
        int left=0;
        int right=nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]>=target){
                right--;
            }
            else{
                 int k=right;
                while(k>left){
        System.out.println("Pair is :"+nums[left]+", "+nums[k--]);
                }
                left++;

            }
           
        }
        
    }
    public static void main(String[] args) {
        int nums[]={-1,1,1,2,3};
        int target=2;

        helper(nums,target);
    }
}
