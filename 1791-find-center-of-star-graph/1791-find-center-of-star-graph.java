class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] degreeCount = new int[n + 1];
        
        for (int[] edge : edges) 
        {
            int u = edge[0];
            int v = edge[1];
            degreeCount[u]++;
            degreeCount[v]++;
        }
        
        for (int i = 1; i <= n; i++) 
        {
            if (degreeCount[i] == n - 1) 
                return i;
        }
        
        return -1;
    }
}