//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
   static int numberOfConsecutiveOnes(int n) {
        // code here
        // Initialize an array to store the values, similar to vector<int> dp(n+1, 0);
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        // If n is less than 3, return the value directly from the dp array
        if (n < 3) {
            return dp[n];
        }

        // Initialize variables a and b
        int a = 0;
        int b = 1;

        // Loop from 3 to n to fill the dp array
        for (int i = 3; i <= n; i++) {
            // Calculate c as (a + b) % 1000000007
            int c = (a + b) % 1000000007;

            // Update dp[i] with the given formula
            dp[i] = (dp[i - 1] * 2) % 1000000007 + c % 1000000007;

            // Ensure dp[i] is within the modulo range
            dp[i] = dp[i] % 1000000007;

            // Update a and b for the next iteration
            a = b;
            b = c;
        }

        // Return the result for dp[n]
        return dp[n];
    }
}
