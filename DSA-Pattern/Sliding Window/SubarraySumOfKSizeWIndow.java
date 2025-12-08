import java.util.ArrayDeque;
import java.util.Deque;

public class SubarraySumOfKSizeWIndow {
    public static int[] calcSum(int arr[],int k){
        int res[]=new int[arr.length-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        int resIdx=0;
        for(int i=0;i<arr.length;i++){
            while(!dq.isEmpty() && dq.peekFirst()<=i-k ){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && arr[i]>arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                res[resIdx++]=arr[dq.peekFirst()];
            }
        }
        return res;
        
    }
    public static void main(String args[]){
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println("Sum of Subarray of k Sized Window is : ");
        for(int e:calcSum(arr, k)){
            System.out.print(e+" ");
        }
        
    }
}
