import java.util.HashMap;

public class LongestRepeatingCharacterReplacement { 
    
    public static int characterReplacement(String s,int k){//TC:O(N^2) SC:O(n) //BruteForce
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            HashMap<Character,Integer> hmap=new HashMap<>();
            int maxFreq=0;
            for(int j=i;j<s.length();j++){
                hmap.put(s.charAt(j),hmap.getOrDefault(s.charAt(j),
                0)+1);
                maxFreq=Math.max(maxFreq,hmap.get(s.charAt(j)));
                int len=j-i+1;
                if(len-maxFreq>k){
                    break;
                }
                maxLen=Math.max(maxLen,len);
            }
        }
        return maxLen;

    }
    public static int characterReplacementOptimized(String s,int k){ //TC: O(n) SC: O(1)
        int maxLen=0;
       int i=0;
       int j=0;
       HashMap<Character,Integer> hmap=new HashMap<>();
       int maxFreq=0;
            while(j<s.length()){
                hmap.put(s.charAt(j),hmap.getOrDefault(s.charAt(j),
                0)+1);
                maxFreq=Math.max(maxFreq,hmap.get(s.charAt(j)));
                while((j-i+1)-maxFreq>k){
                   hmap.put(s.charAt(i),hmap.get(s.charAt(i))-1);
                   i++;
                }
                maxLen=Math.max(maxLen,(j-i+1));
                j++;
            }
        return maxLen;

    }

    public static int characterReplacementMostOptimized(String s,int k){//TC:O(n) SC: O(1)
        int maxLen=0;
        int map[]=new int[26]; // as String contains only English alphabet characters
        int maxFreq=0;
        int i=0;
        int j=0;
        while(j<s.length()){
               map[s.charAt(j)-'A']++;
                maxFreq=Math.max(maxFreq,map[s.charAt(j)-'A']);
               
                while((j-i+1)-maxFreq>k){
                   map[s.charAt(i)-'A']--;
                   i++;
                }
                maxLen=Math.max(maxLen,(j-i+1));
                j++;
        }
        return maxLen;

    }
    public static void main(String[] args) {
        String s = "AABBABBB";
        int k = 1;
        System.out.println("Bruteforce Approach : "+characterReplacement(s, k)); //Output 6
        System.out.println("Optimized Approach : "+characterReplacementOptimized(s, k)); //Output 6
        System.out.println("MostOptimized Approach : "+characterReplacementMostOptimized(s, k)); //Output 6
    }
}
