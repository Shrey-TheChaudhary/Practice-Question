//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                String[] input = br.readLine().trim().split(" ");
                ArrayList<Integer> node = new ArrayList<>();
                for (String s : input) {
                    if (!s.isEmpty()) {
                        node.add(Integer.parseInt(s));
                    }
                }
                adj.add(node);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfs(adj);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    private void dfsUtil(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> list,boolean[] visit,int idx){
        visit[idx]=true;
        list.add(idx);
        for(int i=0;i<adj.get(idx).size();i++){
            int neighbour=adj.get(idx).get(i);
            if(visit[neighbour]) continue;
            dfsUtil(adj,list,visit,neighbour);
        }
    }
    
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> list=new ArrayList<>();
        boolean[] visit=new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(!visit[i]){
                dfsUtil(adj,list,visit,i);
            }
        }
        
        return list;
    }
}