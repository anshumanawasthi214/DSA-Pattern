public class PalindromeList {
    public static boolean checkPalindrome(String s){
        int left=0;
        int right=s.length()-1;

        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            else{
                
                return false;
            }
        }
                  return true;
                       

    }
    public static void main(String args[]){
        String s="levael";
       if(checkPalindrome(s)){
         System.out.println("String is palindrome");
       }else{
        System.out.println("String is not palindrome");
       }
    }
}
