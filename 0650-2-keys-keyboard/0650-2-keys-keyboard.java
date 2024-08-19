import java.util.Arrays;

class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0;
        if (n <= 5) return n;

        int dp[][] = new int[n + 1][n + 1];
        for (int row[] : dp) {
            Arrays.fill(row, 1001);  // Fill with a large number to represent infinity
        }

        dp[1][0] = 0;  // Starting point: 1 character with no copy

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i + j <= n) {
                    dp[i + j][j] = Math.min(dp[i + j][j], dp[i][j] + 1);  // Paste operation
                }
                if (i * 2 <= n) {
                    dp[i * 2][i] = Math.min(dp[i * 2][i], dp[i][j] + 2);  // Copy and Paste operation
                }
            }
        }

        int minSteps = 1001;
        for (int j = 0; j <= n; j++) {
            minSteps = Math.min(minSteps, dp[n][j]);
        }

        return minSteps;
    }
}
