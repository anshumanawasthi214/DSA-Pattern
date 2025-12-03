import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FruitIntoBasket {

    public static int totalFruit(int fruits[]){ //TC : O(n^2) SC : O(1)
       int totalFruits=0;
       for(int i=0;i<fruits.length;i++){
        Set<Integer> set=new HashSet<>();
        for(int j=i;j<fruits.length;j++){
            set.add(fruits[j]);
            if(set.size()>2){
                break;
            }
            totalFruits=Math.max(totalFruits,j-i+1);
        }
       }
        return totalFruits;
    }

    public static int totalFruitOptimized(int fruits[]){ //TC : O(n) SC : O(1)
       int totalFruits=0;
       HashMap<Integer,Integer> hmap=new HashMap<>();
       int i=0;

        for(int j=0;j<fruits.length;j++){
           hmap.put(fruits[j],hmap.getOrDefault(fruits[j],0)+1);
           while(hmap.size()>2){
                hmap.put(fruits[i],hmap.get(fruits[i])-1);
                    if(hmap.get(fruits[i])==0){
                        hmap.remove(fruits[i]);
                    }
                    i=i+1;
                }      
            totalFruits=Math.max(totalFruits,j-i+1);
        }
        return totalFruits;
    }

    public static void main(String[] args) {
int[] fruits = {1,2,1};
System.out.println("Bruteforce Approach : "+totalFruit(fruits)); // Output: 5
System.out.println("Optimized Approach : "+totalFruitOptimized(fruits)); // Output: 5
   

}
}
