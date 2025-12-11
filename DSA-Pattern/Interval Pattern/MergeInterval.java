import java.util.ArrayList;
import java.util.List;

public class MergeInterval{
    public static void main(String args[]){
        int nums[][]={{1,3},{2,6},{8,10},{15,18}};
        List<int[]> answer=new ArrayList<>();
        answer.add(new int[]{nums[0][0],nums[0][1]});
        for(int i=1;i<nums.length;i++){
          int[] last=answer.get(answer.size()-1);
          int interval[]=nums[i];
          if(last[1]>=interval[0]){
            last[0]=Math.min(interval[0],last[0]);
            last[1]=Math.max(interval[1],last[1]);
          }
          else{
            answer.add(new int[]{nums[i][0],nums[i][1]});
          }
        }

        for(int e[]:answer){
            System.out.print("["+e[0]+", "+e[1]+"]");
        }
    }
}
