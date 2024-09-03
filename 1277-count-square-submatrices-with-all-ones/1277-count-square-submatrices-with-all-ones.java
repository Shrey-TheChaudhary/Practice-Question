class Solution {
    public int countSquares(int[][] matrix) {
        int count = 0;  // Initialize count of squares

        // Iterate through the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j =0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0 && i>0 && j>0) {
                    // Update the cell value to be the minimum of its top, left, and top-left neighbors plus 1
                    matrix[i][j] = Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1])) + 1;
                }
                    count += matrix[i][j];  // Add the square size to count
            }
        }

        return count;  // Return the count of squares
    }
}