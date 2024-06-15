//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    // Keypad layout
    private static final int[][] keyPad = {
        {1, 2, 3}, 
        {4, 5, 6}, 
        {7, 8, 9}, 
        {-1, 0, -1}
    };
    
    // Possible movements: right, left, down, up
    private static final int[] dirX = {0, 0, 1, -1};
    private static final int[] dirY = {1, -1, 0, 0};
    
    public long getCount(int N) {
        // Memoization table
        long[][] dp = new long[10][N + 1];
        
        // Initialize memoization table with -1 (unvisited)
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        
        long ans = 0;
        
        // Start from each key and calculate the count of sequences
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (keyPad[i][j] != -1) {
                    ans += helper(i, j, N, dp);
                }
            }
        }
        
        return ans;
    }
    
    private long helper(int i, int j, int N, long[][] dp) {
        // Base case: if sequence length is 1, there is exactly one way to form it
        if (N == 1) return 1;
        
        // Check memoization table
        if (dp[keyPad[i][j]][N] != -1) return dp[keyPad[i][j]][N];
        
        long ans = 0;
        
        // Stay on the same key
        ans += helper(i, j, N - 1, dp);
        
        // Move to adjacent keys
        for (int k = 0; k < 4; k++) {
            int newI = i + dirX[k];
            int newJ = j + dirY[k];
            
            if (newI >= 0 && newJ >= 0 && newI < 4 && newJ < 3 && keyPad[newI][newJ] != -1) {
                ans += helper(newI, newJ, N - 1, dp);
            }
        }
        
        // Save result in memoization table
        return dp[keyPad[i][j]][N] = ans;
    }
}