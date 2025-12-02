import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "bacdacbb";
        System.out.println("BruteForce : "+lengthOfLongestSubstring(s));

        System.out.println("Optimized : "+lengthOfLongestSubstringOptimized(s));

    }

    private static int lengthOfLongestSubstring(String s) {//TC: O(n^2) SC: O(n)
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            Set<Character>set=new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(set.contains(s.charAt(j))){
                    break;
                }
                set.add(s.charAt(j));
                maxLen=Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;
         
    }

private static int lengthOfLongestSubstringOptimized(String s) {//TC: O(n) SC : O(n)
    int maxLen=0;
        
            Set<Character>set=new HashSet<>();
            int i=0;
            for(int j=0;j<s.length();j++){
                    while(set.contains(s.charAt(j))){
                        set.remove(s.charAt(i));
                        i++;
                    }
                
                set.add(s.charAt(j));
                maxLen=Math.max(maxLen,j-i+1);
            }
        
        return maxLen;
         
    }
}
