import java.util.Arrays;

public class ReverseWordsInAString {
    
    // public static String reverseString(String s){ //Bruteforce Approach  
    //     //Time complexity : O(n)
    //     //Space Complexity : O(n)

    //     //it basically removes the leading and trailing spaces
    //     s=s.trim();  

    //     System.out.println("After applying trim : \""+s+"\"");// 'the     sky is  blue'

    //     String st[]=s.split("\\s+"); 

    //     System.out.println("After splitting the string s : "+Arrays.toString(st));//[the, sky, is, blue]

    //     int i=0;
    //     int j=st.length-1;
    //     while(i<j){ //Reversing the String 
    //         String temp=st[i];
    //         st[i]=st[j];
    //         st[j]=temp;
    //         i++;
    //         j--;
    //     }

    //     return String.join(" ",st); // joining the string with spaces
    // }

    public  static void reverse(StringBuilder sb,int i,int j){
        while(i<j){
            char temp=sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j,temp);
            i++;
            j--;
        }
    }

    public static void reverseString(String s){
        int l=0;
        int r=s.length()-1;
        while(s.charAt(l)==' '){
            l++;
        }
        while(s.charAt(r)==' '){
            r--;
        }
        StringBuilder sb=new StringBuilder();

        while(l<=r){
             if(sb.isEmpty()){
                sb.append(s.charAt(l));
                l++;
             }

             if(sb.charAt(sb.length()-1)==' ' && s.charAt(l)==' '){
                l++;
             }
             else{
                sb.append(s.charAt(l));
                l++;
             }
        }
        System.out.println(sb.toString());
        reverse(sb,0,sb.length()-1);
        System.out.println(sb.toString());
        int i=0;
        int j=0;
        while(j<sb.length() && sb.charAt(j)!=' '){
            while(j<sb.length() ){
                j++;
            }
            reverse(sb,i,j-1);
            i=j+1;
            j++;
        }
        System.out.println(sb.toString());

    }


    public static void main(String[] args) {
        String s="   the     sky is  blue   ";
        System.out.println("String before reversing : "+s);
//System.out.println("After reversing the string : \""+reverseString(s)+"\""); //Bruteforce Approach


reverseString(s);
    }
}
