class Solution {
    int minCost(int[] height) {
        int n = height.length;
        if (n == 1) {
            return 0; // No cost if there's only one stone
        }

        // dp[i] = minimum cost to reach index i
        int[] dp = new int[n];

        // Base case: Cost to reach stone 0 is 0
        dp[0] = 0;

        // Base case: Can only jump from stone 0 to stone 1
        dp[1] = Math.abs(height[1] - height[0]);

        // Fill the rest of the dp table
        for (int i = 2; i < n; i++) {
            // Option 1: Jump from i-1
            int cost1 = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            
            // Option 2: Jump from i-2
            int cost2 = dp[i - 2] + Math.abs(height[i] - height[i - 2]);

            // The minimum cost to reach stone 'i' is the minimum of the two options
            dp[i] = Math.min(cost1, cost2);
        }

        // The final answer is the min cost to reach the last stone
        return dp[n - 1];
    }
}