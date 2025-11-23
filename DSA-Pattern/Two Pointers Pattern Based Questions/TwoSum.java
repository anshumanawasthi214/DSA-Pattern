import java.util.HashMap;

public class TwoSum {

    public static void twoSum(int[] arr,int target){
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int requiredValue=target-arr[i];
            if(hmap.containsKey(requiredValue)){
                System.out.println(" The pairs are : "+hmap.get(requiredValue)+" "+i);
                return ;
            }
            hmap.put(arr[i], i);
        }
        System.out.println("No Pair Found");
    }
    public static void main(String args[]){
        int arr[]={2,7,11,15};
        int target=9;

        TwoSum.twoSum(arr,target);
    }
}
