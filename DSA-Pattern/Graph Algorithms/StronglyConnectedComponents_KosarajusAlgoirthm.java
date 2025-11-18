import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StronglyConnectedComponents_KosarajusAlgoirthm {

    // --------------------------------------------------------------------
    // 1️⃣ DFS on ORIGINAL GRAPH – used to fill stack in order of finish time
    // --------------------------------------------------------------------
    public static void dfs(int u, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stk, boolean[] vis) {

        // Mark current node as visited
        vis[u] = true;

        // Visit all neighbours
        for (int v : adj.get(u)) {
            if (!vis[v]) {
                dfs(v, adj, stk, vis);
            }
        }

        // After exploring all outgoing edges, push node to stack
        // (this represents "finish time order")
        stk.push(u);
    }

    // --------------------------------------------------------------------
    // 2️⃣ DFS on TRANSPOSED GRAPH – used to group nodes into one SCC
    // --------------------------------------------------------------------
    public static void img_dfs(int u, ArrayList<ArrayList<Integer>> img, boolean[] vis) {

        // Mark node visited
        vis[u] = true;

        // Explore all incoming edges from the reversed graph
        for (int v : img.get(u)) {
            if (!vis[v]) {
                img_dfs(v, img, vis);
            }
        }
    }

    // --------------------------------------------------------------------
    // 3️⃣ Main function to compute number of strongly connected components
    // --------------------------------------------------------------------
    public static int kosaraju(ArrayList<ArrayList<Integer>> adj) {

        int n = adj.size();

        // Stack to store vertices based on finish time (from dfs)
        Stack<Integer> stk = new Stack<>();

        // Visited array for first DFS
        boolean vis[] = new boolean[n];

        // ---------------------------
        // Step 1: Perform DFS to fill stack according to finish times
        // ---------------------------
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, adj, stk, vis);
            }
        }

        // ---------------------------
        // Step 2: Create TRANSPOSE graph
        // Every edge u → v becomes v → u
        // ---------------------------
        ArrayList<ArrayList<Integer>> img = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            img.add(new ArrayList<>());
        }

        // Reverse edges
        for (int u = 0; u < n; u++) {
            for (int v : adj.get(u)) {
                img.get(v).add(u);  // reverse direction
            }
        }

        // ---------------------------
        // Step 3: DFS on reversed graph in stack order
        // Each DFS gives one complete SCC
        // ---------------------------
        Arrays.fill(vis, false);
        int count = 0;

        while (!stk.isEmpty()) {
            int top = stk.pop();  // get node in decreasing finish time order

            // If not visited in reversed graph → start new SCC
            if (!vis[top]) {
                img_dfs(top, img, vis);
                count++;  // This DFS discovered one full SCC
            }
        }

        return count;
    }

    // --------------------------------------------------------------------
    // Driver code for testing
    // --------------------------------------------------------------------
    public static void main(String[] args) {

        // Graph represented as adjacency list using arrays
        // edges[i] contains all nodes reachable from node i
        int[][] edges = {
            {2, 3},   // edges from 0
            {0},      // edges from 1
            {1},      // edges from 2
            {4},      // edges from 3
            {}        // edges from 4
        };

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < edges.length; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill adjacency list with edges
        for (int i = 0; i < edges.length; i++) {
            for (int e : edges[i]) {
                adj.get(i).add(e);
            }
        }

        // Output the count of strongly connected components
        System.out.println("The number of Strongly Connected Components is: " + kosaraju(adj));
    }
}
