import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_II{
    public static boolean containsNearbyDuplicate(int[] nums,int k){ //TC-O(n^2) SC=O(n)  won't work for large K
                for(int i=0;i<nums.length;i++){
                    Set<Integer>set=new HashSet<>();
                    for(int j=i;j<=Math.min(i+k,nums.length-1);j++){
                        if(set.contains(nums[j])){
                            return true;
                        }
                        set.add(nums[j]);
                    }
                }
                return false;
    }

    public static boolean containsNearbyDuplicateOptimized(int nums[],int k){ //TC: O(n)  SC: O(n)
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println("BruteForce approach : "+containsNearbyDuplicate(nums, k));//Bruteforce 
        System.out.println("Optimized approach : "+containsNearbyDuplicateOptimized(nums, k));
    }
}