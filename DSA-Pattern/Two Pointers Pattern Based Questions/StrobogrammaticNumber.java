import java.util.HashMap;

public class StrobogrammaticNumber { // A strobogrammatic Number is a number which remains same after the rotation of 180 degree 
    // Eg: "198861"->"198861" remains same after rotation

    // public static void checkNumber(String s){  Method 1:
    //         int left=0;
    //         int right=s.length()-1;
    //         while(left<=right){
    //             if((s.charAt(left)=='0' && s.charAt(right)=='0')  ||
    //                 (s.charAt(left)=='1' && s.charAt(right)=='1') ||
    //                 (s.charAt(left)=='6' && s.charAt(right)=='9') ||
    //                 (s.charAt(left)=='8' && s.charAt(right)=='8') ||
    //                 (s.charAt(left)=='9' && s.charAt(right)=='6')){
    //                 left++;
    //                 right--;
    //             }
    //             else{
    //                 System.out.println("Number is not strobogrammatic : "+s);
    //                 return ;
    //             }
    //         }

    //         System.out.println("This is an strobogrammatic Number "+s);
    // }
     public static void checkNumber(String s){ //Method 2:
            int left=0;
            int right=s.length()-1;
            HashMap<Character,Character> hmap=new HashMap<>();
            hmap.put('0','0');
            hmap.put('1','1');
            hmap.put('6','9');
            hmap.put('8','8');
            hmap.put('9','6');
            while(left<=right){
                char l=s.charAt(left);
                char r=s.charAt(right);
                if(hmap.containsKey(l)){
                    if(hmap.get(l)!=r){
                        System.out.println("Number is not strobogrammatic : "+s);
                        return ;
                    }
                    left++;
                    right--;
                }
                else{
                    System.out.println("Number is not strobogrammatic : "+s);
                    return ;
                }
            }

            System.out.println("This is an strobogrammatic Number "+s);
    }

    public static void main(String[] args) { //Time Complexity -> O(n)  
                                            // Space Complexity -> O(1)
        String s="198891";


        checkNumber(s);
    }
}
