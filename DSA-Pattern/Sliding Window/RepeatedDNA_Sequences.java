import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNA_Sequences {
     public static List<String> findRepeatedDnaSequences(String s) {//TC:O(n) SC:O(n)
        Set<String> ans = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            
           String sb=s.substring(i, i + 10);
            if (set.contains(sb)) {
                ans.add(sb);

            } else {
                set.add(sb);
            }

        }
        return ans.stream().toList();
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result=findRepeatedDnaSequences(s);
        System.out.println("repeating dna sequences : "+result);
    }
}

