public class SortTwoColors {
    public static void sortColor(int[] arr){

        int left=0;
        int right=arr.length-1;
        while(left<right){
            if(arr[left]==1 && arr[right]==0){
                arr[left]=arr[left]+arr[right];
                arr[right]=arr[left]-arr[right];
                arr[left]=arr[left]-arr[right];
                left++;
                right--;
            }
            else if(arr[left]==0 && arr[right]==1){
                left++;
                right--;
            }
            else if(arr[left]==0 && arr[right]==0){
                left++;
            }
            else{
                right--;
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
    public static void main(String[] args) {
        int arr[]={1,0,0,0,1,0,1,0,1,1,1,0,0,1,1,0,0,0,1,1,1,0,0,0};

        sortColor(arr);
    }
}
