import java.util.*;

public class LastStoneWeight{
    //BruteForce Approach  Time Complexity: O(n^2)  Space Complexity: O(n)
    public static int lastStoneWeight(int stone[]){
            // Convert into dynamic array
            List<Integer> list=new ArrayList<>();
            for(int s:stone){
                list.add(s);
            }

            while(list.size()>1){
                Collections.sort(list);
                int x=list.remove(list.size()-1);
                int y=list.remove(list.size()-1);
                if(x!=y){
                    list.add(Math.abs(x-y));
                }
            }
            return list.size()==0?0:list.get(0);
    }
    //Optimized Approach      Time Complexity= O(n log n) Space Complexity= O(n)
    public static int lastStoneWeightOptimized(int[] stones){
            // Convert into Max Heap
            PriorityQueue<Integer> list=new PriorityQueue<>(Collections.reverseOrder());
            for(int s:stones){
                list.add(s);
            }

            while(list.size()>1){
                int x=list.poll();
                int y=list.poll();
                if(x!=y){
                    list.add(Math.abs(x-y));
                }
            }
            return list.size()==0?0:list.poll();
    }
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));//BruteForce 
        System.out.println(lastStoneWeightOptimized(stones));//Optimized
    }
}