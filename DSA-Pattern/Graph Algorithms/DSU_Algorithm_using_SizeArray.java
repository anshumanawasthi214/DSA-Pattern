import java.util.Arrays;

public class DSU_Algorithm_using_SizeArray {

    int find(int x,int[] parent){
        if(parent[x]==x)return x;

        return parent[x]=find(parent[x],parent);
    }

    void union(int x,int y,int parent[],int size[]){
        int parent_x=find(x,parent);
        int parent_y=find(y,parent);

        if(parent_x==parent_y)return ;

        int size_x=size[parent_x];
        int size_y=size[parent_y];

        if(size_x>size_y){
            parent[parent_y]=parent_x;
            size[parent_x]+=size_y;
        }
        else if(size_y>size_x){
            parent[parent_x]=parent_y;
            size[parent_y]+=size_x;
        }
        else{
            parent[parent_x]=parent_y;
            size[parent_y]+=size_x;
        }
    }

    public static void main(String[] args) {
        
        int V=7;

        int parent[]=new int[V];
        for(int i=0;i<V;i++){
            parent[i]=i;
        }

        int size[]=new int[V];
        Arrays.fill(size, 1);

         DSU_Algorithm_using_SizeArray dsu = new DSU_Algorithm_using_SizeArray();

        // ----------------------
        // Sample Input
        // ----------------------
        dsu.union(0, 1, parent, size);
        dsu.union(1, 2, parent, size);
        dsu.union(3, 4, parent, size);
        dsu.union(2, 4, parent, size); // connects 0-1-2-3-4 together

        // Check if 0 and 4 belong to same component
        System.out.println("Find(0) = " + dsu.find(0, parent));
        System.out.println("Find(4) = " + dsu.find(4, parent));

        System.out.println("Are 0 and 4 connected? " +
                (dsu.find(0, parent) == dsu.find(4, parent)));

        // printing final parent array
        System.out.println("Parent array: " + Arrays.toString(parent));
        System.out.println("Size array: " + Arrays.toString(size));

    }
}
