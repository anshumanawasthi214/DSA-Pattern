public class AppendCharacterToStringToMakeSubsequence{

    public static int appendCharacters(String s, String t) {
        int left=0;
        int right=0;
        while(left<s.length() && right<t.length()){
            if(s.charAt(left)==t.charAt(right)){
                right++;
            }
                left++;
        }
        return t.length()-right;
    }
    public static void main(String[] args) { //Time Complexity : O(n)
                                             //Space Complexity: O(1)
        String s="coaching";
        String t="coding";

        int numberOfCharacter=appendCharacters(s,t);
        System.out.println(" minimum number of characters that need to be appended "+numberOfCharacter);
    }
}