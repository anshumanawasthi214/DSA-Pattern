public class Palindrome_II {
    public static boolean isPalindrome(int left,int right,String s){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))return false;

            left++;
            right--;
        }
        return true;
    }
    public static boolean palindromeCheck(String ch){
        int left=0;
        int right=ch.length()-1;
        while(left<right){

            if(ch.charAt(left)!=ch.charAt(right)){
                return isPalindrome(left+1, right, ch) || isPalindrome(left,right-1, ch);
                
            }
            
                left++;
                right--;
            
        }
        return true;
    }
    public static void main(String[] args) {
        String s="abca";

        if(palindromeCheck(s)){
            System.out.println("String is palindrome");
         }
         else{
           
            System.out.println("String is not Palindrome");
         }
        
    }
}
