//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int n, int matrix[][])
    {
        int dp[][]=new int [n][n];
        
        for(int j=0;j<n;j++)
            dp[0][j]=matrix[0][j];
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int up=matrix[i][j]+dp[i-1][j];
                
                int leftdig=matrix[i][j];
                if(j-1>=0)
                    leftdig+=dp[i-1][j-1];
                else
                    leftdig+=(int)Math.pow(-10,9);
                
                 int rightdig=matrix[i][j];
                if(j+1<n)
                    rightdig+=dp[i-1][j+1];
                else
                    rightdig+=(int)Math.pow(-10,9);
                
                dp[i][j]=Math.max(up,Math.max(leftdig,rightdig));
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            max=Math.max(max,dp[n-1][i]);
        
        return max;
    }
}