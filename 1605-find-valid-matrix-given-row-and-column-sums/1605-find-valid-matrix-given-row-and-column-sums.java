class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] arr = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0 ; j < colSum.length; j++) {
                arr[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= arr[i][j];
                colSum[j] -= arr[i][j];
            }
        }
        return arr;
    }
}