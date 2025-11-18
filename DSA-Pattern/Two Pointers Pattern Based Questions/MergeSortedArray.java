public class MergeSortedArray{

    public static void merge(int nums1[],int nums2[],int n,int m){
        int i=n-1;
        int j=m-1;
        int k=nums1.length-1;

        while(i<m && j<n){
                if(nums1[i]<nums2[j]){
                    nums1[k++]=nums1[i++];
                }
                else if(nums1[i]==nums2[j]){
                    nums1[k++]=nums1[i++];
                }
                else{
                    nums1[k++]=nums2[j++];
                }
        }
        for(int a:nums1){
            System.out.print(a+" ");
        }


    }
    public static void main(String[] args) {
        int arr[]={1,2,3,0,0,0};
        int arr2[]={2,5,6};

        int n=3;
        int m=arr2.length;
        merge(arr,arr2,n,m);
    }
}