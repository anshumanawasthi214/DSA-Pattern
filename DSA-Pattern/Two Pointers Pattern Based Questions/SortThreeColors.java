public class SortThreeColors {
    /*This problem also known as Dutch National Flag Problem */
    public static void sortThreeColors(int arr[]){
        int i=0;
        int k=0;
        int j=arr.length-1;
        while(k<=j){
            if(arr[k]==1){
                k++;
            }
            else if(arr[k]==0){
                int temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
                i++;
                k++;
            }
            else{
                int temp=arr[j];
                arr[j]=arr[k];
                arr[k]=temp;
                j--;
            }
        }
        
        for(int I=0;I<arr.length;I++){
            System.out.print(arr[I]+" ");
        }

    }
    public static void main(String[] args) {
        int arr[]={0,0,0,0,2,0,1,0,2,2,2,0,2,0};
       
        sortThreeColors(arr);
    }
}
