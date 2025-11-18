import java.util.Arrays;

public class KruskalAlgorithm{// This is an algorithm to find minimum spanning tree Using Kruskal Algorithm
    
    public static void union(int x,int y,int parent[],int rank[]){
      int rank_x=rank[x];
      int rank_y=rank[y];
      
      if(rank_x>rank_y){
          parent[y]=x;
      }
      else if(rank_x<rank_y){
          parent[x]=y;
      }
      else{
          parent[x]=y;
          rank[y]++;
      }
      
    }
    
    public static int find(int x,int[] parent){
        if(parent[x]==x)return x;
        
        parent[x]=find(parent[x],parent);
        return parent[x];
    }
    
    static int kruskalsMST(int V, int[][] edges) {

            Arrays.sort(edges,(a,b)->a[2]-b[2]);
            
            int parent[]=new int[V];
            for(int i=0;i<V;i++){
                parent[i]=i;
            }
            int rank[]=new int[V];
            int cost=0;
            for(int[] e:edges){
               int x=find(e[0],parent);
               int y=find(e[1],parent);
               
               if(x!=y){
                   union(x,y,parent,rank);
                   cost+=e[2];
                }
            }
            
            return cost;
}

public static void main(String args[]){
    int[][] edges={{0,1,5},{1,2,3},{0,2,1}};
    int V=3;
    System.out.println("Minimum Cost to Connect all the edges: "+kruskalsMST(V, edges));
}

}