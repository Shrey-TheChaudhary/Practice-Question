//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxSquare(int rows, int cols, int matrix[][]) {
        // Create a 2D array 'dp' where dp[i][j] will store the size of the largest square
        // sub-matrix with all 1s that ends with cell (i, j)
        int dp[][] = new int[rows][cols];
        
        // Variable to store the size of the largest square found
        int maxSize = 0;
        
        // Iterate through each cell of the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell contains a 1, it might be part of a square sub-matrix
                if (matrix[i][j] == 1) {
                    // If the cell is in the first row or first column,
                    // it can only form a square of size 1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // Otherwise, the size of the square ending at (i, j) will be
                        // the minimum of the sizes of squares ending at:
                        // (i-1, j-1), (i-1, j), and (i, j-1) plus 1
                        dp[i][j] = Math.min(dp[i-1][j-1],
                                            Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    }
                    // Update maxSize if we found a larger square
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }
        
        // Return the size of the largest square found
        return maxSize;
    }
}