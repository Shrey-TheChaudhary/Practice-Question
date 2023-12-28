//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     static boolean flag = false;
    static int verifyMatch(int i , int j , String wild, String pattern,int dp [][]){
     
        if(i<0 && j<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if(j<0){
            while(i>=0 && wild.charAt(i)=='*'){
                i--;
            }
            if(i<0){
               return 1;
            }
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(wild.charAt(i)==pattern.charAt(j)){
         return  dp[i][j] = verifyMatch(i-1,j-1,wild,pattern,dp);
        } else if(wild.charAt(i)=='*'){
            
            if(verifyMatch(i-1,j-1,wild,pattern,dp)==1){
                return dp[i][j] = 1;
            } else if(verifyMatch(i,j-1,wild,pattern,dp)==1){
                return dp[i][j]=1;
            } else if( verifyMatch(i-1,j,wild,pattern,dp)==1){
                return dp[i][j]=1;
            }

        } else if(wild.charAt(i)=='?'){
            dp[i][j] =  verifyMatch(i-1,j-1,wild,pattern,dp);
        // } else if(wild.charAt(i)!=pattern.charAt(j)){
        //     dp[i][j] = 0;
        // }
        } else {
            dp[i][j] = 0;
        }
        return dp[i][j];
    }
    static boolean match(String wild, String pattern)
    {
        // code here
        
        int m = wild.length()-1;
        int n = pattern.length()-1;
        
        int dp [][] = new int [m+1][n+1];
        for(int a []:dp){
            Arrays.fill(a,-1);
        }
        int ans = verifyMatch(m,n,wild,pattern,dp);
        // System.out.println(ans);
        return ans==1;

    }
}