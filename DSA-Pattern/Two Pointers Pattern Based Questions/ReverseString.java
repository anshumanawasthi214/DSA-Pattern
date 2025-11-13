public class ReverseString{

    public static void Reverse(char[] ch){
        int left=0;
        int right=ch.length-1;
        while(left<right){
            char temp=ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;
            right--;
        }
        for(char c:ch){
            System.out.print(c+" ");
        }
    }



    public static void main(String[] args) {
        char[] arr={'h','e','l','l','o','o'};

        Reverse(arr);
    }
}