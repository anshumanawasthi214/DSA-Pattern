import java.util.Arrays;

public class MeetingRooms{
    public static void main(String[] args){
         int nums[][]={{2,6},{1,3},{8,10},{15,18}};
    
        Arrays.sort(nums,(a,b)->a[0]-b[0]);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i][0]+" "+nums[i][1]);
        }
        
        for(int i=1;i<nums.length;i++){
          int[] last=nums[i-1];
          int interval[]=nums[i];
          if(last[1]>=interval[0]){
            System.out.println("Conflicts are happening between meetings");
            return ;
          }
          
        }

        System.out.println("Meetings can be schedule without any conflicts");
    }
}