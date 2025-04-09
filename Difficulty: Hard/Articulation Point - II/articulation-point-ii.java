//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {

    static int[] time;
    static int[] low;
    static boolean[] critical;
    static int timer;

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Step 2: Initialize structures
        time = new int[V];
        low = new int[V];
        critical = new boolean[V];
        timer = 1;

        // Step 3: DFS on unvisited nodes
        for (int i = 0; i < V; i++) {
            if (low[i] == 0) {
                dfs(i, -1, adj);
            }
        }

        // Step 4: Collect articulation points
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (critical[i]) result.add(i);
        }

        if (result.size() == 0) result.add(-1);
        return result;
    }

    private static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj) {
        time[node] = low[node] = timer++;
        int child = 0;

        for (Integer nbr : adj.get(node)) {
            if (nbr == parent) continue;

            if (low[nbr] == 0) {
                dfs(nbr, node, adj);
                child++;

                low[node] = Math.min(low[node], low[nbr]);

                if (low[nbr] >= time[node] && parent != -1) {
                    critical[node] = true;
                }
            } else {
                low[node] = Math.min(low[node], time[nbr]);
            }
        }

        if (parent == -1 && child > 1) {
            critical[node] = true;
        }
    }
}
