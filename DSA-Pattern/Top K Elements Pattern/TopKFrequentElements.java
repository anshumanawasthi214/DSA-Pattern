import java.util.*;
public class TopKFrequentElements{
    //Time Complexity: O(nlogk) and Space Complexity: O(n)
    public static int[] topKFrequent(int arr[],int k){
        HashMap<Integer,Integer>hmap=new HashMap<>();
        for(int num:arr){
            hmap.put(num,hmap.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer>heap=new PriorityQueue<>(
            (a,b)->hmap.get(a)-hmap.get(b)
        );

        for(int key:hmap.keySet()){
            heap.add(key);
            if(heap.size()>k){
                heap.poll();
            }

        }
        int result[]=new int[k];
        for(int i=0;i<k;i++){
            result[i]=heap.poll();
        }
        return result;
    }
    public static void main(String args[]){
        int arr[]={1,1,1,2,2,3};
        int k=2;
        int result[]=topKFrequent(arr,k);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}