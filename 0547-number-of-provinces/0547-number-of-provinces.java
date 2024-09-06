class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        int[] vis = new int[V]; //boolean[] vis = new boolean[V];
        int count = 0;
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){ //if(!vis[i]){.....}
                count++;
                dfs(i, vis, isConnected);
            }
        } return count;
        
    }
    private void dfs(int node, int[] vis, int[][] connected){
        vis[node] = 1; //vis[node]=true
        for(int i = 0; i < connected.length; i++){
            if(vis[i] == 0 && connected[node][i] == 1){
                dfs(i, vis, connected);
            }
        }
    }
}