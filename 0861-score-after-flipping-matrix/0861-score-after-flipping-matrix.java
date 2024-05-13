import java.util.*;

class Solution {
    public int matrixScore(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Ensure the most significant bit in each row is set to 1
        for (int r = 0; r < rows; r++) {
            if (grid[r][0] == 0) {
                toggleRow(grid, r);
            }
        }
        
        // Count the number of zeros in each column (excluding the first column)
        Map<Integer, Integer> counts = new HashMap<>();
        for (int c = 1; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                if (grid[r][c] == 0) {
                    counts.put(c, counts.getOrDefault(c, 0) + 1);
                }
            }
        }
        
        // Calculate the total score
        int totalScore = rows * (1 << (cols - 1));
        for (int c = 1; c < cols; c++) {
            totalScore += Math.max(counts.getOrDefault(c, 0), rows - counts.getOrDefault(c, 0)) * (1 << (cols - c - 1));
        }
        
        return totalScore;
    }
    
    // Helper method to toggle a row
    private void toggleRow(int[][] grid, int rowIndex) {
        for (int c = 0; c < grid[0].length; c++) {
            grid[rowIndex][c] ^= 1; // Toggle bit
        }
    }
}
