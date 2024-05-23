//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String input_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            int k = Integer.parseInt(input_line[1]);
            String str = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.kPalindrome(str, n, k));
        }
    }
}
// } Driver Code Ends


class Solution {
    Integer dp[][];
    public int kPalindrome(String str, int n, int k) {
        dp = new Integer[n][n];
        // return solve(0,n-1,str)<=k?1:0;
        
        StringBuilder sb = new StringBuilder(str);
        String str2 = sb.reverse().toString();
        return tab(str,str2,n)<=2*k?1:0;
    }
    int tab(String s1,String s2,int n){
        int dp[][] = new int[n+1][n+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0)    dp[i][j]=j;
                else if(j==0)   dp[i][j]=i;
                else if(s1.charAt(i-1)==s2.charAt(j-1))    dp[i][j]=dp[i-1][j-1];
                else    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;
            }
        }
        
        return dp[n][n];
    }
    int solve(int i,int j,String s){
        if(i>=j)    return 0;
        if(dp[i][j]!=null)  return dp[i][j];
        
        if(s.charAt(i)==s.charAt(j))    return dp[i][j] = solve(i+1,j-1,s);
        return dp[i][j] = Math.min(solve(i+1,j,s), solve(i,j-1,s)) +1;
    }
}