import java.util.TreeMap;

public class CarPooling{
    public static void main(String args[]){
         int ride[][]={{2,1,5},{3,3,7}};
         int capacity=4;
            System.out.println("Approach 1 "+carPoolingApproach1(ride,capacity));
             System.out.println("Approach 2 "+carPoolingApproach1(ride,capacity));
    }


    public static boolean carPoolingApproach1(int[][] ride,int capacity){
        //TC:O(NlogN) SC:O(N)
        //Brute Force using TreeMap
        TreeMap<Integer,Integer> tmap=new TreeMap<>();
        for(int i=0;i<ride.length;i++){
            int p=ride[i][0];
            int s=ride[i][1];
            int e=ride[i][2];
            tmap.put(s,tmap.getOrDefault(s,0)+p);
            tmap.put(e,tmap.getOrDefault(e,0)-p);
        }
        int currCapacity=0;
        for(int e:tmap.keySet()){
            currCapacity+=tmap.get(e);
            if(currCapacity>capacity)return false;
        }
        return true;
    }

    public static boolean carPoolingApproach2(int[][] ride,int capacity){
        //TC:O(N) SC:O(1)
        //Optimal using array as per constraints
        
        int map[]=new int[1002]; // as per constraints of leetcode
        for(int i=0;i<ride.length;i++){
            int p=ride[i][0];
            int s=ride[i][1];
            int e=ride[i][2];
            map[s]+=p;
            map[e]-=p;
        }
        int currCapacity=0;
        for(int i=0;i<map.length;i++){
            currCapacity+=map[i];
            if(currCapacity>capacity)return false;
        }
        return true;
    }
}