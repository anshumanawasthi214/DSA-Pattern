public class Valid_Word_Abbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int i=0;
        int j=0;
        while(i<word.length() && j<abbr.length()){
            char a=abbr.charAt(j);
            if(Character.isDigit(a)){
                if(a=='0'){
                    return false;
                }
                int curr=0;
                while(j<abbr.length() && Character.isDigit(abbr.charAt(j))){
                         curr=curr*10+(abbr.charAt(j))-'0';
                         j++;
                }
            i+=curr;        
            }
            else{
                 if(word.charAt(i)!=abbr.charAt(j)){
                        return false;
                 }
                 i++;
                 j++;
            }
           
           
            
        }
        return i==word.length() && j==abbr.length();
    }
    public static void main(String args[]){

/*For example, the string "implementation" can be abbreviated in several ways, such as:
"i12n" -> ("i mplementatio n")
"imp4n5n" -> ("imp leme n tatio n")
"14" -> ("implementation")
"implemetation" -> (no substrings replaced)


Invalid abbreviations include:
"i57n" -> (i mplem entatio n, adjacent substrings are replaced.)
"i012n" -> (has leading zeros)
"i0mplementation" (replaces an empty substring) */


        String word="implementation";
        String abbr="imp4n5n";
        System.out.println(validWordAbbreviation(word,abbr));
    }
}