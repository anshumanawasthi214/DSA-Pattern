public class PalindromeList {

    public static boolean checkPalindrome(String s){
        int left = 0, right = s.length() - 1;

        while(left < right){
            // Skip non-alphanumeric characters from the left
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            // Skip non-alphanumeric characters from the right
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            // Compare characters (case-insensitive)
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args){
        String s = "    raCE.   car,";
        
        if(checkPalindrome(s)){
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }
    }
}
