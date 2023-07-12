class Solution {
    public int findCircleNum(int[][] isConnected)
    {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        
        return provinces;
    }
      private void dfs(int[][] arr, boolean[] visited, int node) {
        visited[node] = true;
        
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[node][i] == 1 && !visited[i]) 
                dfs(arr, visited, i);
        }
    }
}