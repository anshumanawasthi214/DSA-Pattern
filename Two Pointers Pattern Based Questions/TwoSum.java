public class TwoSum{

    public static boolean twoSum(int arr[],int target){
        int left=0;
        int right=arr.length-1;
        boolean found=false;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum<target){
                left++;
            }
            else if(sum>target){
                right--;
            }
            else{
            System.out.println("Pairs are: "+left+" "+right+" for Target :"+target);
            
               found=true;
               left++;
               right--;
            }
        }
         return found;

    }


    public static void main(String args[]){
        int arr[]={2,3,6,7,8,11};
        int target=9;

        if(!(TwoSum.twoSum(arr,target))){
            System.out.println("Target cant be achieve");
        }



        
    }
}