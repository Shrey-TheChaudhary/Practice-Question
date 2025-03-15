//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
          int n = coins.length;
        int[][] dp = new int[n][sum + 1];
        for(int i =0; i <= sum; i++) {
            if(i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = (int)(1e9);
            }
        }
        for(int ind = 1; ind  < n; ind++) {
            for(int target = 0; target <= sum; target++) {
                int notTake = dp[ind - 1][target];
                int take = Integer.MAX_VALUE;
                if(coins[ind] <= target) {
                    take = 1 + dp[ind][target - coins[ind]];
                }
                dp[ind][target] = Math.min(take, notTake);
            }
        }
        return dp[n-1][sum] >= (int)(1e9) ? -1 : dp[n-1][sum];
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends