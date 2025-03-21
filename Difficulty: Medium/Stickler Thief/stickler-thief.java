//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int n=arr.length;
        int[][] dp = new int[n][2];
    if (n== 1) {
      return arr[0];
    }
 
    // Initialize the values in dp array
    dp[0][0] = 0;
    dp[0][1] = arr[0];
 
    // Loop to find the maximum possible sum
    for (int i = 1; i < n; i++) {
      dp[i][1] = dp[i - 1][0] + arr[i];
      dp[i][0] = Math.max(dp[i - 1][1],dp[i - 1][0]);
    }
 
    // Return the maximum sum
    return Math.max(dp[n - 1][0], dp[n- 1][1]);
    }
}