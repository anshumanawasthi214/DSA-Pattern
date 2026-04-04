import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReOrganizeString{
    static class HeapElement{
        char cH;
        int count;
        public HeapElement(char cH,int count){
            this.cH=cH;
            this.count=count;
        }
    }

    public static String reorganizeString(String s){
        HashMap<Character,Integer> hmap=new HashMap<>();
       
        for(int i=0;i<s.length();i++){
            hmap.put(s.charAt(i),hmap.getOrDefault(s.charAt(i),0)+1);
        }
         PriorityQueue<HeapElement> heap=new PriorityQueue<>(
                                                    (a,b)->b.count-a.count
                                                    );

        for(Map.Entry<Character,Integer> entry:hmap.entrySet()){
            heap.add(new HeapElement(
                entry.getKey(),
                entry.getValue()
            ));
        }
       

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();i++){
                HeapElement max=heap.poll();
                if(sb.length()==0 || sb.charAt(sb.length()-1)!=max.cH){
                    sb.append(max.cH);
                    max.count=max.count-1;

                    if(max.count>0){
                        heap.add(max);
                    }
                    continue ;
                }
                else if(max.cH==sb.charAt(sb.length()-1)){
                    if(heap.isEmpty()){
                        return "Not Possible";
                    }
                    HeapElement smax=heap.poll();
                    sb.append(smax.cH);
                    smax.count=smax.count-1;
                    
                    if(smax.count>0){
                        heap.add(smax);
                    }
                    heap.add(max);
                    continue ;
                }
                else{
                    return "Not Possible";
                }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "aaabb";
        System.out.println(reorganizeString(s));
    }
}