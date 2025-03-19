//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.maxProfit(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int maxProfit(int A[], int K) {
        // code here
        int N=A.length;
         if (K == 0 || N < 2) {
            return 0;
        }
        
        // dp[i][j] represents maximum profit using at most i transactions up to day j
        int[][] dp = new int[K + 1][N];
        
        // For each transaction
        for (int i = 1; i <= K; i++) {
            // maxDiff keeps track of maximum profit we can have if we buy stock on day j
            int maxDiff = -A[0];
            
            // For each day
            for (int j = 1; j < N; j++) {
                // Maximum of:
                // 1. Previous day's profit (no transaction today)
                // 2. Selling on current day + maxDiff (complete transaction today)
                dp[i][j] = Math.max(dp[i][j-1], A[j] + maxDiff);
                
                // Update maxDiff if we can get better profit by buying on current day
                maxDiff = Math.max(maxDiff, dp[i-1][j] - A[j]);
            }
        }
        
        return dp[K][N-1];
    }
}