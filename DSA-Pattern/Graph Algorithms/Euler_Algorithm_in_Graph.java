import java.io.*;
import java.util.*;

public class Euler_Algorithm_in_Graph {

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) throws Exception {
        // Use Scanner but skip non-integer tokens gracefully
        Scanner sc = new Scanner(System.in);

        // helper to move scanner to next integer token, or return false if none
        if (!moveToNextInt(sc)) {
            System.err.println("No integers found in input. Expected: V E ...");
            return;
        }
        int V = sc.nextInt();

        if (!moveToNextInt(sc)) {
            System.err.println("Missing number of edges. Expected: V E ...");
            return;
        }
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        int edgesRead = 0;
        while (edgesRead < E && sc.hasNext()) {
            // find next integer token for u
            if (!moveToNextInt(sc)) break;
            int u = sc.nextInt();

            // find next integer token for v
            if (!moveToNextInt(sc)) break;
            int v = sc.nextInt();

            // convert from 1-based to 0-based if needed; adapt if your input is 0-based
            u--; v--;
            if (u >= 0 && u < V && v >= 0 && v < V) {
                addEdge(adj, u, v);
            }
            edgesRead++;
        }

        sc.close();

        Solution sol = new Solution();
        int ans = sol.isEulerCircuit(V, adj);
        System.out.println(ans);
    }

    // skip tokens until the scanner has an int; return true if found
    private static boolean moveToNextInt(Scanner sc) {
        while (sc.hasNext()) {
            if (sc.hasNextInt()) return true;
            sc.next(); // skip the bad token
        }
        return false;
    }
}

// keep your Solution class here (same as before)
class Solution {

    private boolean isConnected(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] deg = new int[V];
        int start = -1;
        for (int i = 0; i < V; i++) {
            deg[i] = adj.get(i).size();
            if (start == -1 && deg[i] > 0) start = i;
        }
        if (start == -1) return true;
        boolean[] vis = new boolean[V];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        vis[start] = true;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int j = 0, sz = adj.get(u).size(); j < sz; j++) {
                int v = adj.get(u).get(j);
                if (!vis[v]) {
                    vis[v] = true;
                    stack.push(v);
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (deg[i] > 0 && !vis[i]) return false;
        }
        return true;
    }

    public int isEulerCircuit(int V, ArrayList<ArrayList<Integer>> adj) {
        V = Math.min(V, adj.size());
        if (!isConnected(V, adj)) return 0;
        int oddCount = 0;
        for (int i = 0; i < V; i++) {
            if ((adj.get(i).size() & 1) == 1) oddCount++;
        }
        if (oddCount == 0) return 2;
        if (oddCount == 2) return 1;
        return 0;
    }
}
