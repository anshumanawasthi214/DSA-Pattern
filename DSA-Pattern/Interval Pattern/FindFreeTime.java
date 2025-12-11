import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindFreeTime {
    public static void main(String[] args) {
         int nums[][]={{1,3},{2,6},{8,10},{15,18}};

          Arrays.sort(nums,(a,b)->a[0]-b[0]);
        List<int[]> answer=new ArrayList<>();
        for(int i=1;i<nums.length;i++){
          int[] last=nums[i-1];
          int interval[]=nums[i];
          if(last[1]<interval[0]){
            answer.add(new int[]{last[1],interval[0]});
          }
         
        }
        System.out.println("Given schedule is : ");
        for(int e[]:nums){
            System.out.print("["+e[0]+", "+e[1]+"] ");
        }
        System.out.println();

        System.out.println("Free time slots are : ");
        for(int e[]:answer){
            System.out.print(e[0]+" <-> "+e[1]+", ");
        }
    }
}
