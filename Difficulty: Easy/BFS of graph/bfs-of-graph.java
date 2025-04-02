//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if(adj==null||adj.size()==0)
        return res;
        
        int n = adj.size();
        boolean[] vis = new boolean[n];
        
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            bfsUtils(adj,i,vis,res);
        }
        return res;
    }
    private void bfsUtils(ArrayList<ArrayList<Integer>> adj,int source,
    boolean[] vis,ArrayList<Integer> res)
    {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(source);
        vis[source] = true;
        
        while(!q.isEmpty())
        {
            Integer currNode = q.poll();
            res.add(currNode);
            
            for(int neighbour:adj.get(currNode))
            {
                if(!vis[neighbour])
                {
                    q.offer(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
    }
}


//{ Driver Code Starts.

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
            ArrayList<Integer> ans = obj.bfs(adj);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends