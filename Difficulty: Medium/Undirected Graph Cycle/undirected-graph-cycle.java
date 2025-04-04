//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
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
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends

class Node{
        int src,dest;
        public Node(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
class Solution {
      
    public boolean dfsUtil(List<Node>[] graph,boolean[] visited,int curr,int par){
        visited[curr]=true;
        for(Node edge:graph[curr]){
            int src=edge.src;
            int neighbour=edge.dest;
            if(visited[neighbour]&&neighbour==par) continue;
            if(visited[neighbour]&&neighbour!=par) return true;
            if(dfsUtil(graph,visited,neighbour,src)) return true;
        }
        
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<Node>[] graph=new ArrayList[V];
        for(int i=0;i<V;i++) graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            int src=edge[0];
            int dest=edge[1];
            graph[src].add(new Node(src,dest));
            graph[dest].add(new Node(dest,src));
        }
        
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfsUtil(graph,visited,i,-1)){
                    return true;
                }
            }
        }
        
        return false;
    }
        
}