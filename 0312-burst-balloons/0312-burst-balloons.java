class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        // Create an extended array with 1 at both ends (virtual balloons)
        int[] a = new int[n + 2];
        a[0] = 1;
        a[n + 1] = 1;
        System.arraycopy(nums, 0, a, 1, n);
        
        //OR
        
            //int[] a = new int[n + 2];
            // a[0] = 1; 
            // a[n + 1] = 1;


            // for (int i = 0; i < n; i++) {
            //     a[i + 1] = nums[i];
            // }

        
       
        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;

                int maxi = Integer.MIN_VALUE;

                // Check all possible last balloons to burst in this subarray
                for (int ind = i; ind <= j; ind++) {
                    int cost = a[i - 1] * a[ind] * a[j + 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    maxi = Math.max(maxi, cost);
                }

                dp[i][j] = maxi;
            }
        }

        // Return the result for bursting all balloons
        return dp[1][n];
    }
}
