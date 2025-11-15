class Solution {
    public int LCIS(int[] arr1, int[] arr2) {
        // code here
        int m=arr1.length,n=arr2.length;
         int[][] dp = new int[n + 1][m + 1];
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int currentMax = 0;
            for (int j = 1; j <= m; j++) {
                if (arr2[i - 1] == arr1[j - 1]) {
                    dp[i][j] = currentMax + 1;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (arr2[i - 1] > arr1[j - 1]) {
                    currentMax = Math.max(currentMax, dp[i - 1][j]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}