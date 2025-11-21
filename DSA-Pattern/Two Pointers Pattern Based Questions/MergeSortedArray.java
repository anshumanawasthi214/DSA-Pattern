public class MergeSortedArray{

    public static void merge(int nums1[],int nums2[],int m,int n){
       int k=(m+n)-1;
       int i=m-1;
       int j=n-1;
      while(i>=0 && j>=0){
        if(nums1[i]>=nums2[j]){
            nums1[k]=nums1[i];
           
            i--;
        }
        else{
            nums1[k]=nums2[j];
           
            j--;
        }
         k--;
      }

      while(j>=0){
        nums1[k--]=nums2[j--];
      }
        

       for(int e:nums1){
        System.out.print(e+" ");
       }

    }
    public static void main(String[] args) {
        int arr[]={0,0,0};
        int arr2[]={2,5,6};

        
        int m=0;
        int n=arr2.length;
        merge(arr, arr2, m, n);
    }
}