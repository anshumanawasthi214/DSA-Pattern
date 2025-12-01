import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfDistinctSubarraysOfSizeK{
    public static int calculateSumOptimized(int nums[],int k){
        HashMap<Integer,Integer>hmap=new HashMap<>();
        int maxSum=0; 
        int left=0;
        int sum=0;
        int dups=0;
        for(left=0;left<k;left++){
            hmap.put(nums[left],hmap.getOrDefault(nums[left],0)+1);
            
            sum+=nums[left];
            if(hmap.get(nums[left])>1){
                dups++;
            }
        }
        if(dups==0){
            maxSum=sum;
        }

        for(int right=k;right<nums.length;right++){
            hmap.put(nums[right],hmap.getOrDefault(nums[right],0)+1);
              if(hmap.get(nums[right])>1){
                dups++;
            }
            sum+=nums[right]-nums[left-k];
            if(hmap.get(nums[left-k])>1){
                    hmap.put(nums[left-k],hmap.get(nums[left-k])-1);
                        dups--;
            }
            else{
                hmap.remove(nums[left-k]);
            }

            if(dups==0){
                maxSum=Math.max(maxSum,sum);
            }
             left++;
 
        }
       
        return maxSum;
    }

    public static int calculateSum(int arr[],int k){ // TC=O(n*k) SC=O(k)
        int maxSum=0;
        
        for(int i=0;i<=arr.length-k;i++){
            Set<Integer>set=new HashSet<>();
            boolean isDuplicate=false;
            int currSum=0;
            for(int j=i;j<i+k;j++){
                if(set.contains(arr[j])){
                    isDuplicate=true;
                    break;
                }
                set.add(arr[j]);
                currSum+=arr[j];

            }
            if(!isDuplicate){
                maxSum=Math.max(maxSum,currSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int arr[]={1,5,4,2,9,9,9};
        int k=3;

        System.out.println(calculateSum(arr,k));//BruteForce Approach

        System.out.println(calculateSumOptimized(arr,k));
    }
}