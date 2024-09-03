//Striver DP-50
class Solution {
    public int minCost(int n, int[] cuts) {
         int c = cuts.length;
        
        // Create an extended cuts array with 0 and n included
        int[] extendedCuts = new int[c + 2];
        extendedCuts[0] = 0;
        extendedCuts[c + 1] = n;
        for (int i = 0; i < c; i++) {
            extendedCuts[i + 1] = cuts[i];
        }
        
        // Sort the cuts array
        Arrays.sort(extendedCuts);
        
        // Initialize the DP table
        int[][] dp = new int[c + 2][c + 2];
        
        // Fill the DP table
        for (int i = c; i >= 1; i--)
        {
            for (int j = 1; j <= c; j++) 
            {
                if (i > j) 
                    continue;
                
                int mini = Integer.MAX_VALUE;
                
                // Compute the minimum cost for this range
                for (int ind = i; ind <= j; ind++) {
                    int cost = extendedCuts[j + 1] - extendedCuts[i - 1] 
                               + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(mini, cost);
                }
                
                dp[i][j] = mini;
            }
        }
        
        // Return the minimum cost to cut the entire stick
        return dp[1][c];
    }
}