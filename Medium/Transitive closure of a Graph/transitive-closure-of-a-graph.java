//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        ArrayList<ArrayList<Integer>> transitive = new ArrayList<>();
        for (int i = 0; i < N; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                temp.add(0);
            }
            transitive.add(temp);
        }
        
        
        for (int i = 0; i < N; i++){
            boolean[] visited = new boolean[N];
            Arrays.fill(visited, false);
            
            ArrayList<Integer> pathFrom = new ArrayList<>();
            dfs(transitive, pathFrom, i, graph, visited);
            
            for (int node: pathFrom) {
                transitive.get(i).set(node, 1);
            }
        }
        
        return transitive;
        
    }
    
    
    static void dfs(ArrayList<ArrayList<Integer>> transitive, ArrayList<Integer> pathFrom, int node, int[][] graph, boolean[] visited) {
        visited[node] = true;
        pathFrom.add(node);
        
        for (int nbr = 0; nbr < graph[node].length; nbr++) {
            if (!visited[nbr] && graph[node][nbr] == 1)
                dfs(transitive, pathFrom, nbr, graph, visited);
        }
        
    }
}