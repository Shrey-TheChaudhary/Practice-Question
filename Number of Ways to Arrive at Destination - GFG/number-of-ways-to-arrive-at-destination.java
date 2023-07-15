//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair{
    int first;int second;
    
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
         int mod=(int)1e9+7;
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        int m=roads.size();
        
        
        for(int i=0;i<m;i++){
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1),roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0),roads.get(i).get(2)));
        }
        
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.first-y.first);
        
        pq.add(new Pair(0,0));
        int dist[]=new int[n];
        int ways[]=new int[n];
        
        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
            ways[i]=0;
        }
        //  Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
        
        while(pq.size()!=0){
            int dis=pq.peek().first;
            int node=pq.peek().second;
            
            pq.remove();
            
            for(Pair it:adj.get(node)){
                int adjnode=it.first;
                int edw=it.second;
                
                
                if(dis+edw<dist[adjnode]){
                    dist[adjnode]=(dis+edw)%mod;
                    pq.add(new Pair( dist[adjnode],adjnode));
                    ways[adjnode]=ways[node];
                }
                else if(dis+edw==dist[adjnode]){
                    ways[adjnode]=(ways[adjnode]+ways[node])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}