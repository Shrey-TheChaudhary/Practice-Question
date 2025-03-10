//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            Solution ob = new Solution();
            int ans = ob.editDistance(s1, s2);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int[] d: dp) Arrays.fill(d, -1);
        return func(n-1, m-1, s1, s2, dp);
    }
    
    int func(int i, int j, String s1, String s2, int[][] dp) {
        if(i < 0) return j + 1;
        if(j < 0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return func(i-1, j-1, s1, s2, dp);
        return dp[i][j] = 1 + Math.min(func(i, j-1, s1, s2, dp), Math.min(func(i-1, j, s1, s2, dp), func(i-1, j-1, s1, s2, dp)));
    }
}

