import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection{
    public static void main(String[] args) {
        int firstList[][]={{0,2},{5,10},{13,23},{24,25}};
        int secondList[][]={{1,5},{8,12},{15,24},{25,26}};

        helper(firstList,secondList);

    }
    public static void helper( int firstList[][], int secondList[][]){ 
        // TC- O(n+m) SC- O(n)
        if(firstList.length==0 ||secondList.length==0){
            System.out.println("[]");
            return ;
        }
        int i=0;
        int j=0;
        List<int[]> ans=new ArrayList<>();
        while(i<firstList.length && j<secondList.length){
            int s1=firstList[i][0];
            int e1=firstList[i][1];
            int s2=secondList[j][0];
            int e2=secondList[j][1];

            if(e1>=s2 && e2>=s1){
                ans.add(new int[]{
                    Math.max(s1,s2),Math.min(e1,e2)
                });
            }

            if(e1<e2){
                i++;
            }
            else{
                j++;
            }
            
        }

        for (int[] interval : ans) {
    System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
    //  O/P -> [1, 2] [5, 5] [8, 10] [15, 23] [24, 24] [25, 25]
}
System.out.println();

    }
}