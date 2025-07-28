class Solution {
    public static int balanceSums(int[][] mat) {
        // code here
         int n = mat.length;

        int[] rowSum = new int[n];
        int[] colSum = new int[n];

        // Calculate row and column sums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }

        // Find the maximum sum among all row sums and column sums
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, rowSum[i]);
            maxSum = Math.max(maxSum, colSum[i]);
        }

        // To make matrix beautiful, we need to make all row and column sums equal to maxSum
        int operations = 0;
        for (int i = 0; i < n; i++) {
            operations += maxSum - rowSum[i]; // Only row difference is enough since total increase should balance column as well
        }

        return operations;
    }
}