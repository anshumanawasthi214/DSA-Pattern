import java.util.HashSet;
import java.util.Set;

public class CircularArrayLoop{

    public static int calcNextIndex(int[] arr,int curr){
        int seq=arr[curr];
        int next=curr;
        if(seq>0){
            next=(curr+seq)%arr.length;
        }
        else{
            int mod=seq%arr.length;
            int forward=mod+arr.length;
            next=(curr+forward)%arr.length;
        }
        return next;
    }

    private static boolean checkCycleAdvanced(int[] nums) { //TC=O(n) SC=O(1)
          for(int i=0;i<nums.length;i++){
            
            
            if(nums[i]==0)continue;
            int slow=i;
            int fast=i;
            boolean isPos=nums[i]>0;
        do{

            slow=calcNextIndex(nums,slow);
            fast=calcNextIndex(nums,fast);
                if(isPos){
                    if(nums[fast]<0){
                        break;
                    }
                }
                else{
                    if(nums[fast]>0){
                        break;
                    }
                }

            fast=calcNextIndex(nums,fast);
             if(isPos){
                    if(nums[fast]<0){
                        break;
                    }
                }
                else{
                    if(nums[fast]>0){
                        break;
                    }
                }

            if(slow==fast){
                //cycle found
                //k>1
                if(slow!=calcNextIndex(nums,slow)){
                    return true;
                }
                break;
            }
        }while(slow!=fast);
            
            int curr=i;

            if(isPos){
                 while(nums[curr]>0){
                        int next=calcNextIndex(nums,curr);
                        nums[curr]=0;
                        curr=next;
                    }
            }else{
                 while(nums[curr]<0){
                        int next=calcNextIndex(nums,curr);
                        nums[curr]=0;
                        curr=next;
                    }
            }
               
            
        }
        return false;
    }

    public static boolean checkCycleModified(int nums[]){//TC=O(n) SC=O(n)
      
          for(int i=0;i<nums.length;i++){
            Set<Integer> set=new HashSet<>();
            set.add(i);
            if(nums[i]==0)continue;
            int curr=i;
            boolean isPos=nums[i]>0;
            while(true){
            int next=calcNextIndex(nums,curr);
                if(isPos){
                   if(nums[next]<0){
                    break;
                   }
                   else{
                    if(set.contains(next)){
                        if(curr!=next){
                            return true;
                        }
                        else{
                            break;
                        }
                    }
                    set.add(next);
                   }
                }
                else{
                     if(nums[next]>0){
                    break;
                   }
                   else{
                    if(set.contains(next)){
                        if(curr!=next){
                            return true;
                        }
                        else{
                            break;
                        }
                    }
                    set.add(next);
                   }

                }
               
               curr=next;
                
            }
            curr=i;

            if(isPos){
                 while(nums[curr]>0){
                        int next=calcNextIndex(nums,curr);
                        nums[curr]=0;
                        curr=next;
                    }
            }else{
                 while(nums[curr]<0){
                        int next=calcNextIndex(nums,curr);
                        nums[curr]=0;
                        curr=next;
                    }
            }
               
            
        }
        return false;
    

    }
   
    public static boolean checkCycle(int arr[]){// TC=O(n^2) SC=O(n)
    
        for(int i=0;i<arr.length;i++){
            Set<Integer>set=new HashSet<>();

            int curr=i;

            //Adding the first index where to start
            set.add(curr);

            boolean isPos=arr[i]>0; // checking if arrays element is positive or negative

            while (true) {
    int next = calcNextIndex(arr, curr);

    // 1. direction check
    if (isPos && arr[next] <= 0) break;
    if (!isPos && arr[next] >= 0) break;

    // 2. self-loop → invalid
    if (next == curr) break;

    // 3. cycle detected (length > 1)
    if (set.contains(next)) return true;

    // 4. move forward
    set.add(next);
    curr = next;
}
        }
        return false;
    }
   
    public static void main(String[] args) {
    int arr[]={1, 1, 0, 1};

        boolean ans=checkCycle(arr);//Bruteforce approach
        System.out.println("Bruteforce Approach: "+ans);

        ans=checkCycleModified(arr);//Modified approach
        System.out.println("Modified Approach: "+ans);

        ans=checkCycleAdvanced(arr);//Modified approach
        System.out.println("Advanced Approach: "+ans);
    }
   
}