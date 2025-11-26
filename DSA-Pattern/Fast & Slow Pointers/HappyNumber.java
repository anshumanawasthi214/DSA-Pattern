// import java.util.HashSet;
// import java.util.Set;

public class HappyNumber {
    
    // public static boolean isHappy(int n) { //O(log n) but not space Optimized  

    //     Set<Integer> set = new HashSet<>(); //O(k) to store k number of elements

    //     while(n != 1 && !set.contains(n)){
    //         set.add(n);
    //         n = getSquare(n);
    //     }

    //     return n == 1;
    // }

    private static int getSquare(int num){
        int sum = 0;
        while(num > 0){ //O(log n)
            int rem = num % 10;
            sum += rem * rem;
            num /= 10;
        }
        return sum;
    }

    public static boolean isHappy(int n){ //O(log n) more Optimized:  no additional space needed
         int slow = n;
        int fast = n;

        while (true) {
            slow = getSquare(slow);
            fast = getSquare(getSquare(fast));
            if (fast == 1){
                return true;
            }

            if (slow == fast) 
                return false;
            }
    }


    public static void main(String[] args) {
        int n=19;
        if(isHappy(n)){
            System.out.println(n+" is Happy Number :)");
        }
        else{
            System.out.println(n+" is not a  Happy Number :( ");

        }

    }
}
