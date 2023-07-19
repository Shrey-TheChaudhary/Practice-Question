//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends



//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
       String a = S;
    String b=new StringBuilder(S).reverse().toString();
    return lcs(a,b);
    }
    
    static int lcs(String a, String b) {
    
    int n=a.length();
    int m=b.length();

    int dp[][]=new int[n+1][m+1];
    
    for(int i=0;i<=n;i++){
        dp[i][0] = 0;
    }
    for(int i=0;i<=m;i++){
        dp[0][i] = 0;
    }
    
    for(int ind1=1;ind1<=n;ind1++)
    {
        for(int ind2=1;ind2<=m;ind2++)
        {
            if(a.charAt(ind1-1)==b.charAt(ind2-1))
                dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
            else
                dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
        }
    }
    
    return dp[n][m];
    }
}