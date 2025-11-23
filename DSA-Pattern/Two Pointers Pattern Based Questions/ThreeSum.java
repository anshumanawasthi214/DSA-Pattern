import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void threeSum(int arr[]){
    List<int[]> ans=new ArrayList<>();
       
        for(int i=0;i<arr.length-2;i++){
            if(i>0 && arr[i]==arr[i-1])continue;
            int left=i+1;
            int right=arr.length-1;
            while(left<right){
                if(arr[i]+arr[left]+arr[right]==0){
                    ans.add(new int[]{arr[i],arr[left],arr[right]});
                    left++;
                    right--;
                    while(left<right && arr[right]==arr[right+1])right--;

                    while(left<right && arr[left]==arr[left-1])left++;

                }
                else if(arr[left]+arr[i]+arr[right]>0){
                   right--;
                }
                else{
                    left++;
                }
            }
        }
    

        for(int j=0;j<ans.size();j++){
            System.out.print("[");
            for(int e:ans.get(j)){
                System.out.print(e+" ,");
            }
              System.out.print("]");
        }
    }
    public static void main(String[] args) {
        int arr[]={-1,0,1,2,-1,-4};
        Arrays.sort(arr);
        threeSum(arr);
    }
}
