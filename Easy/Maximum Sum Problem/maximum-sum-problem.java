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
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSum(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maxSum(int n) 
    { 
        if(n == 0 || n == 1)
            return n;
            
        int dp[] = new int[n + 1];
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) 
        {
            int sum = dp[i / 2] + dp[i / 3] + dp[i / 4];
            dp[i] = Math.max(i, sum);
        }
        
        return dp[n];
    } 
}