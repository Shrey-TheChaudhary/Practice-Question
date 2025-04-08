//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // Convert edge list to adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] visited = new int[V];

        // Count number of connected components before removing the edge
        Arrays.fill(visited, 0);
        int disjointSets = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                bfs(i, adj, c, d, false, visited);
                disjointSets++;
            }
        }

        // Count number of connected components after removing the edge
        Arrays.fill(visited, 0);
        int disjointSets2 = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                bfs(i, adj, c, d, true, visited);
                disjointSets2++;
            }
        }

        return disjointSets != disjointSets2;
    }

    private void bfs(int src, ArrayList<ArrayList<Integer>> adj, int c, int d, boolean check, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.poll();
            visited[node] = 1;

            for (int next : adj.get(node)) {
                if (check && ((node == c && next == d) || (node == d && next == c)))
                    continue;
                if (visited[next] != 1) {
                    q.add(next);
                }
            }
        }
    }
}



//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            // V and E on separate lines
            int V = Integer.parseInt(sc.nextLine().trim());
            int E = Integer.parseInt(sc.nextLine().trim());

            // Using a 2D array to store edges.
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                // Use split("\\s+") to handle one or more whitespace characters
                String[] parts = sc.nextLine().trim().split("\\s+");
                edges[i][0] = Integer.parseInt(parts[0]);
                edges[i][1] = Integer.parseInt(parts[1]);
            }

            // c and d on separate lines
            int c = Integer.parseInt(sc.nextLine().trim());
            int d = Integer.parseInt(sc.nextLine().trim());

            Solution obj = new Solution();
            boolean result = obj.isBridge(V, edges, c, d);
            System.out.println(result ? "true" : "false");
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends