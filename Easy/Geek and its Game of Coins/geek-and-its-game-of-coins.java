//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.findWinner(n, x, y);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution
{
    public int findWinner(int N,int X,int Y)
    {
        boolean[] dp = new boolean[N + 1];
        dp[0] = false;
        dp[1] = true;

        for (int i = 2; i <= N; i++) {
            if (i - 1 >= 0 && !dp[i - 1]) {
                dp[i] = true;
            } else if (i - X >= 0 && !dp[i - X]) {
                dp[i] = true;
            } else if (i - Y >= 0 && !dp[i - Y]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        return dp[N] ? 1 : 0;
    }
}