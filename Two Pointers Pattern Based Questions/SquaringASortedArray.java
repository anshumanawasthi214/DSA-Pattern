public class SquaringASortedArray {

    public static void square(int nums[]){
        int left=0;
        int right=nums.length-1;
        int res[]=new int[nums.length];
        int k=nums.length-1;
         while(left<=right){
            int leftSquare=nums[left]*nums[left];
            int rightSquare=nums[right]*nums[right];
            if(leftSquare<rightSquare){
                res[k]=rightSquare;
                right--;
            }
            else{
                res[k]=leftSquare;
                left++;
            }
             k--;
        }
        System.out.println("This is the input Sorted Array");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        System.out.println("This is the output Sorted Squared array:");
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){

        int arr[]={-11,-2,3,4,5,6,7,8,9,9};

        square(arr);
    }
}
