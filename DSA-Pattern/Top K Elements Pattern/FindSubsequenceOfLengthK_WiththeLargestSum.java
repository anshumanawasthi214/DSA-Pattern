import java.util.*;
public class FindSubsequenceOfLengthK_WiththeLargestSum {
    
    public static void maxsubsequence(int nums[],int k){//Time complexity: O(nlogn) due to sorting, Space complexity: O(n) for the temp array

        int temp[][]=new int[nums.length][2]; // 2D array to store the elements and their original indices

        // Fill the temp array with elements and their indices
        for(int i=0;i<nums.length;i++){
            temp[i][0]=nums[i];
            temp[i][1]=i;
        }
        // Sort the temp array based on the values in descending order
        Arrays.sort(temp,(a,b)->b[0]-a[0]);

        // Sort the first k elements based on their original indices to maintain the order in the result
        Arrays.sort(temp,0,k,(a,b)->a[1]-b[1]);

        int result[]=new int[k]; // Array to store the final result

// Fill the result array with the first k elements from the sorted temp array
        for(int i=0;i<k;i++){
            result[i]=temp[i][0];
            System.out.print(result[i]+" ");// Print the result
        }

        
    }

    public static void optimizedmaxsubsequence(int nums[],int k){//TC: O(nlogK) SC: O(k) due to the min-heap

        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->a[0]-b[0]);// Min-heap to store the top k elements and their indices

        for(int i=0;i<k;i++){   // Add the first k elements to the heap
            heap.add(new int[]{nums[i],i});
        }

        for(int i=k;i<nums.length;i++){// Iterate through the remaining elements
            if(nums[i]>heap.peek()[0]){
                    heap.remove();
                    heap.add(new int[]{nums[i],i});
            }
        }
        
        int[][] result=new int[k][];// Array to store the top k elements and their indices from the heap

        for(int i=0;i<k;i++){// Poll the top k elements from the heap and store them in the result array
            result[i]=heap.poll();
        }

        Arrays.sort(result,(a,b)->a[1]-b[1]);// Sort the result array based on the original indices to maintain the order in the final output

        int ans[]=new int[k];// Array to store the final result
        for(int i=0;i<result.length;i++){
            ans[i]=result[i][0];
            System.out.print(ans[i]+" ");// Print the final result
        }
        
    }
    public static void main(String args[]){
       int nums[] = {-1,-2,3,4};
       int  k = 3;

        maxsubsequence(nums,k);
        System.out.println();
        optimizedmaxsubsequence(nums,k);
    }
}
