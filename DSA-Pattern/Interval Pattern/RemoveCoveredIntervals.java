public class RemoveCoveredIntervals {

    public static void approach1(int[][] intervals){ 
        //Bruteforce approach TC: O(n^2) SC: O(1)
        int count=0;
        for(int i=0;i<intervals.length;i++){
            boolean flag=false;
            int a=intervals[i][0];
            int b=intervals[i][1];
            for(int j=0;j<intervals.length;j++){
                int c=intervals[j][0];
                int d=intervals[j][1];

                if(i!=j && (c<=a && b<=d)){
                        flag=true;
                        break;
                }
            }
            if(!flag){
                count++;
            }
        }
        System.out.println("Count is : "+count);
    }
    public static void main(String[] args) {
        int arr[][]={{1,4},{3,6},{2,8}};

        approach1(arr);
    }
}
