class Solution {
    public int networkDelayTime(int[][] edge, int n, int k) {
        int[] dis = new int[n+1]; 
        int max = -1;
        
        for(int i = 0; i < dis.length; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        
        dis[k] = 0;
        
        for(int i = 1; i <= n; ++i){
            for(int j = 0; j < edge.length; ++j){
                int u = edge[j][0];
                int v = edge[j][1];
                int w = edge[j][2];
                if(dis[u] != Integer.MAX_VALUE && dis[u] + w < dis[v]){
                    dis[v] = dis[u] + w;
                }
            }
        }
        
        for(int i = 1; i < dis.length; i++){
            if(dis[i] > max){
                max = dis[i];
            }
        }
       
      return (max == Integer.MAX_VALUE)? -1 : max;
    }
}