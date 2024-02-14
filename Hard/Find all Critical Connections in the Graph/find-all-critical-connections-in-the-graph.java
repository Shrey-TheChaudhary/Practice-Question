//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.criticalConnections(V, adj);
            for(int i=0;i<ans.size();i++)
                System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj){
        int vis[] = new int[v+1];
        int cst[] = new int[v+1];
        Arrays.fill(cst,-1);
        this.ans = new ArrayList<>();
        tra(0,1,adj,vis,cst,-1);
        Collections.sort(ans,(a,b)->{
            int one = Integer.compare(a.get(0),b.get(0));
            int two = Integer.compare(a.get(1),b.get(1));
            if(one==0)return two;
            return one;
        });
        return ans;
    }
    private int tra(int node ,int level, ArrayList<ArrayList<Integer>> adj , int vis[] , int cst[] , int par){
        cst[node] = level;
        vis[node] = 1;
        int min = level;
        for(int ed : adj.get(node)){
            if(ed==par)continue;
            if(vis[ed]==0){
                int val = tra(ed,level+1,adj,vis,cst,node);
                min = Math.min(min , val);
                if(level<val){
                    ArrayList<Integer> ans = new ArrayList<Integer>();
                    if(node<ed){
                        ans.add(node);
                        ans.add(ed);
                    }else{
                        ans.add(ed);
                        ans.add(node);
                    }
                    this.ans.add(ans);
                }
            }else{
                min = Math.min(min,cst[ed]);
            }
        }
        cst[node] = min;
        return min;
    }
}