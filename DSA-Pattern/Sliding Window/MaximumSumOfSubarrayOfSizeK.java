public class MaximumSumOfSubarrayOfSizeK {

    public static int calculateSum(int arr[],int k){
        
        int sum=0;
       for(int i=0;i<k;i++){
            sum+=arr[i];
       }
       int maxSum=sum;

      for(int i=k;i<arr.length;i++){
            sum+=arr[i]-arr[i-k]; //Add new, Remove old
            maxSum=Math.max(sum,maxSum);
            
       }
       return maxSum;
    }
    public static void main(String[] args) {
        int arr[]={2,1,5,1,3,2};
        int k=3;

        System.out.println(" The max sum of all these : "+calculateSum(arr,k));
    }
}
