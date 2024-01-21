//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.vertexCover(n, m, edges);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int vertexCover(int n, int m, int[][] edges) {
        int all = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i  <= n ; i++)adj.add(new ArrayList<>());
        for(int ed[] : edges){
            adj.get(ed[0]).add(ed[1]);
            adj.get(ed[1]).add(ed[0]);
        }
        int dp[] = new int[(1<<n)<<1];
        Arrays.fill(dp,-1);
        return mini(all,adj,dp);
        
    }
    private static int mini(int mask , ArrayList<ArrayList<Integer>> adj,int dp[]){
        if(dp[mask]!=-1)return dp[mask];
        int ans = (int)1e9;
        boolean add = false;
        for(int i = 1 ; i < adj.size() ; i++){
            if((mask&(1<<i))==0){
                boolean can = true;
                for(int v : adj.get(i)){
                    if((mask&(1<<v))==0){
                        can = false;
                        break;
                    }
                }
                if(!can){
                    add = true;
                    break;
                }
            }
        }
        if(!add){
            return Integer.bitCount(mask);
        }
        for(int i = 1 ; i < adj.size() ; i++){
            if((mask&(1<<i))==0){
                ans = Math.min(ans , mini(mask|((1<<i)) , adj,dp));
            }
        }
        
        return dp[mask]=ans;
    }
}
