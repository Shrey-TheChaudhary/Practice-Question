class Solution 
{
    public boolean isBipartite(int[][] graph)
     {
        int n = graph.length;
        int color[] = new int[n];
         Arrays.fill(color,-1);
           for(int i=0;i<n;i++) 
           {
             if(color[i] == -1) 
             {
               // if(check(i, graph, color) == false) 
               //    return false;
                 
                //DFS function 
                 if(dfs(i, 0, color, graph) == false)
                 return false; 

             }
           }
           return true;
    }
    
     // private boolean check( int start,int graph[][], int color[])
     //  {
     //     Queue<Integer> q = new LinkedList<Integer>();
     //     q.add(start);
     //     color[start] = 0;
     //     while( !q. isEmpty()) 
     //     {
     //         int node = q.peek();
     //         q. remove();
     //         for(int it : graph[node])
     //          {
     //             if(color[it] == -1) 
     //             {
     //                 color[it] = 1 - color[node];
     //                 q.add(it);
     //             }
     //               else if(color[it] == color[node]) 
     //                 return false;
     //          }
     //     }  
     //     return true;
     // }
    private boolean dfs(int node, int col, int[] color, int[][] adj) {
    color[node] = col; 
    
    // Traverse adjacent nodes
    for (int it = 0; it < adj[node].length; it++) {
        // If uncolored
        if (color[adj[node][it]] == -1) {
            if (!dfs(adj[node][it], 1 - col, color, adj)) return false; 
        }
        // If previously colored and have the same color
        else if (color[adj[node][it]] == col) {
            return false; 
        }
    }
    
    return true; 
}
}