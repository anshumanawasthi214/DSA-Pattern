import java.util.*;
public class MergeIntervals {
    public static void main(String[] args) {
         int intervals[][]={{1,3},{2,6},{8,10},{15,18}};

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> answer=new ArrayList<>();
        answer.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
          int[] prev=answer.get(answer.size()-1);
          
          if(prev[1]>=intervals[i][0]){
            prev[1]=Math.max(prev[1],intervals[i][1]);
          }
          else{
            answer.add(intervals[i]);
          }
        }
        System.out.println("Given intervals are : ");
        for(int e[]:intervals){
            System.out.print("["+e[0]+", "+e[1]+"] ");
        }
        System.out.println();

        System.out.println("Merged Intervals are : ");
        for(int e[]:answer){
            System.out.print(e[0]+" <-> "+e[1]+", ");
        }
    }


}
