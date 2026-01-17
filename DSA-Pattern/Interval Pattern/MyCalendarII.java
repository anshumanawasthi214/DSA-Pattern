import java.util.TreeMap;

public class MyCalendarII {
    public  TreeMap<Integer, Integer> calendar;
   
      public MyCalendarII(){
            calendar =new TreeMap<>();
        }


    public static void main(String[] args) {

        MyCalendarII myCalendarTwo = new MyCalendarII();
        System.out.println(myCalendarTwo.book(10, 20)); // return true
        System.out.println(myCalendarTwo.book(50, 60)); // return true
        System.out.println(myCalendarTwo.book(10, 40)); // return true
        System.out.println(myCalendarTwo.book(5, 15));  // return false
        System.out.println(myCalendarTwo.book(5, 10));  // return true
        System.out.println(myCalendarTwo.book(25, 55)); // return true
    }

    public boolean book(int start, int end) {
       calendar.put(start,calendar.getOrDefault(start,0)+1); 
       calendar.put(end,calendar.getOrDefault(end,0)-1);
        if(!LineSweep(calendar)){
             calendar.put(start,calendar.getOrDefault(start,0)-1);
             calendar.put(end,calendar.getOrDefault(end,0)+1);

            if (calendar.get(start) == 0) calendar.remove(start);
            if (calendar.get(end) == 0) calendar.remove(end);
            
             return false;
        }else{
            return true;
        }
    }

    public boolean LineSweep(TreeMap<Integer,Integer>calendar){
         int roomsNeeded=0;
        for(int e:calendar.values()){
            roomsNeeded+=e;
            if(roomsNeeded>2){
                return false;
            }
        }
        return true;
    }

}
