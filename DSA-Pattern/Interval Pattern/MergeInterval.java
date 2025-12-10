import java.util.ArrayList;
import java.util.List;

public class MergeInterval{
    public static void main(String args[]){
        int interval[][]={{1,3},{2,6},{8,10},{15,18}};
        List<int[]> answer=new ArrayList<>();

        for(int i=1;i<interval.length;i++){
            if(interval[i-1][1]>=interval[i][0] ){
                interval[i-1][1]=Math.max(interval[i][1],interval[i-1][1]);
            }
            else if(interval[i-1][0]>=interval[i][0] && interval[i-1][1]<=interval[i][1] ||interval[i][0]>=interval[i-1][0] && interval[i][1]<=interval[i-1][1] ){
                   
            }
        }
    }
}