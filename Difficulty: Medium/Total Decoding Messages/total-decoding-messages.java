//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    private int dp[];
    public int countWays(String digits) {
        // code here
        dp = new int[digits.length()+1];
        Arrays.fill(dp , -1);
        int ans = countDecodes(0 , digits);
        return ans;
    }
    
    private int countDecodes(int i, String digits) {
        if(i >= digits.length()) {
            return 1;
        } else if(digits.charAt(i) == '0') {
            return 0;
        } else if(dp[i] != -1) {
            return dp[i];
        }
        dp[i] = countDecodes(i+1 , digits);
        int digit1 = digits.charAt(i) - '0';
        if(i+1 < digits.length() && (digit1 == 1 || (digit1 == 2 && digits.charAt(i+1) <= '6'))) {
            dp[i] += countDecodes(i+2 , digits);
        }
        return dp[i];
    }
}
