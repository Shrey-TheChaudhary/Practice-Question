class Solution {
    public int shortCycle(int V, int[][] edges) {
    
        List<List<Integer>> adj= new ArrayList<>();
        for( int i=0;i<V;i++)
        adj.add(new ArrayList<>());
        
        for( int u[]: edges)
        {
            adj.get(u[0]).add(u[1]);
            adj.get(u[1]).add(u[0]);
        }
        int min= V+1;
        for( int k=0;k<V;k++){
        Queue<Integer> q= new ArrayDeque<>();
        int dis[]=new int[V];
        int par[]= new int[V];
        Arrays.fill(dis, -1);
        Arrays.fill(par,-1);
        
        q.offer(k);
        dis[k]=0;
        while(!q.isEmpty())
        {
            int u= q.poll();
            for( int v: adj.get(u))
            {
                if( dis[v]==-1)
                {
                    dis[v]=1+dis[u];
                    q.offer(v);
                    par[v]=u;
                }
                else if( par[u]==v)
                continue;
                else
                {
                    min=Math.min(1+dis[u]+dis[v], min);
                }
            }
          }
        }
        return min==V+1? -1: min;
    }
}