//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int n, int arr[])
    {int ans=0;
        int totalsum=0;
        for(int i:arr)
        totalsum+=i;
        
        if(totalsum%2==1)
        return ans;
        else
        {
             int k = totalsum/2;
            boolean dp[][]=new boolean[n][k+1];
        for(int i=0;i<n;i++)
        dp[i][0]=true;
        
        if(arr[0]<=k)
        dp[0][arr[0]]=true;
        
        for(int ind=1;ind<n;ind++)
        {
            for(int target=1;target<=k;target++)
            {
                boolean nottake=dp[ind-1][target];
                boolean take=false;
                
                if(arr[ind]<=target)
                take=dp[ind-1][target-arr[ind]];
                
                dp[ind][target]=take||nottake;
            }
        }
        
        if(dp[n-1][k]==false)
        ans= 0;
        else
        ans= 1;
        }
        return ans;
    }
}