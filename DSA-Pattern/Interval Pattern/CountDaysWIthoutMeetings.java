import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountDaysWIthoutMeetings {
    public static void main(String[] args) {
        int days = 10;
        int meetings[][]={{5,7},{1,3},{9,10}};

        helper(days,meetings);
        helper1(days,meetings);
    }

    public static void helper(int days,int[][] meetings){// Optimized
        //TC:O(nlogN) SC:O(1)
        int maxEnd=0;
        int gap=0;
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        maxEnd=meetings[0][1];
        for(int i=1;i<meetings.length;i++){
            if(meetings[i][0]>maxEnd){
                    gap+=(meetings[i][0]-maxEnd)-1;
            }
           
                maxEnd=Math.max(maxEnd,meetings[i][1]);
            
        }

        int startGap=meetings[0][0]-1;
        int endGap=days-maxEnd;
        System.out.println(gap+startGap+endGap);

    }

    public static void helper1(int days,int[][] meetings){//better
        //TC: O(nlogN) SC: O(n)
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        List<int[]> ans=new ArrayList<>();
        ans.add(new int[]{meetings[0][0],meetings[0][1]});
        for(int i=1;i<meetings.length;i++){
            if(ans.get(ans.size()-1)[1]>=meetings[i][0]){
                ans.get(ans.size()-1)[0]=Math.min(ans.get(ans.size()-1)[0],
                meetings[i][0]);
                ans.get(ans.size()-1)[1]= Math.max(ans.get(ans.size()-1)[1],meetings[i][1]);

            }else{
                ans.add(new int[]{meetings[i][0],meetings[i][1]});
            }
        }
        int meetingDays=0;
        for(int[] interval:ans){
             meetingDays+=(interval[1]-interval[0])+1;
        }
        System.out.println(days-meetingDays);
    }
}
