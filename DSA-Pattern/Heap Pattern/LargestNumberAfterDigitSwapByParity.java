import java.util.Collections;
import java.util.PriorityQueue;

public class LargestNumberAfterDigitSwapByParity {
    //Time Complexity: O(n^2) where n is the number of digits in the input number.
    //Space Complexity: O(n) where n is the number of digits in the input number
    public static long largestInteger(long num){
        char arr[]=String.valueOf(num).toCharArray();
         for(int i=0;i<arr.length;i++){
            int maxPos=i;
              for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[maxPos] && (arr[i]-arr[j])%2==0){
                    maxPos=j;
                }
              }
              char temp=arr[i];
              arr[i]=arr[maxPos];
              arr[maxPos]=temp;
                  
        }
        String number=String.valueOf(arr);
        return Long.parseLong(number);
    }

    //Time Complexity: O(n log n) where n is the number of digits in the input number.
    //Space Complexity: O(n) where n is the number of digits in the input number
     public static long largestIntegerOptimized(long num){
       PriorityQueue<Character> even=new PriorityQueue<>(Collections.reverseOrder());
       PriorityQueue<Character> odd=new PriorityQueue<>(Collections.reverseOrder());
        for(char c:String.valueOf(num).toCharArray()){
            if((c-'0')%2==0){
                even.add(c);
            }else{
                odd.add(c);
            }
        }
            StringBuilder sb=new StringBuilder();
        for(char c:String.valueOf(num).toCharArray()){
            if((c-'0')%2==0){
                sb.append(even.poll());
            }else{
               sb.append(odd.poll());
            }
        }
       
        return Long.parseLong(sb.toString());
    }
    public static void main(String[] args) {
        long num = 1234567893114L;
        
System.out.println(largestInteger(num));
System.out.println(largestIntegerOptimized(num));
    }
}
