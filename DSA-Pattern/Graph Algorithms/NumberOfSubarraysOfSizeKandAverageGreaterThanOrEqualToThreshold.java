public class NumberOfSubarraysOfSizeKandAverageGreaterThanOrEqualToThreshold{

 public static int numOfSubarrays(int[] arr, int k, int threshold) {//BruteForce
                        //TC: O(n*k) SC: O(1)
        int answer=0;
        for(int i=0;i<=arr.length-k;i++){
            int sum=0;
            for(int j=i;j<Math.min(arr.length,i+k);j++){
                    sum+=arr[j];
            }
            if(sum/k>=threshold){
                answer++;
            }

        }
        return answer;
    }

     public int numOfSubarraysOptimized(int[] arr, int k, int threshold) {
        //TC: O(n+k)=O(n)  SC: O(1)
         int sum=0;
        int answer=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }

        if(sum/k>=threshold){
            answer++;
        }

        for(int j=k;j<arr.length;j++){
            sum+=arr[j]-arr[j-k];
            if(sum>=threshold*k){
                answer++;
            }   
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;
        System.out.println("Bruteforce Approach: "+numOfSubarrays(arr, k, threshold));
        System.out.println("Optimized Approach: "+numOfSubarrays(arr, k, threshold));

    }
}