public class RemoveDuplicates {
    public static void remove(int arr[]){
        int left=0;
        int right=1;
        while(right<arr.length){
            if(arr[left]==arr[right]){
                right++;
            }
            else if(arr[left]!=arr[right]){
                arr[++left]=arr[right];
                right++;
            }
        }
        for(int i=0;i<=left;i++){
            System.out.print(arr[i]+" ");

        }
    }
    public static void main(String args[]){
        int arr[]={1,1,2,2,3,3,4,5,6,6,7,7,8,9,11};

        remove(arr);
    }
}
