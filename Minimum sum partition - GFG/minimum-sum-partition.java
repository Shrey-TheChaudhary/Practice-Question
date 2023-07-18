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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int nums[], int n) 
	{ 
        int totalsum = 0;
  for (int i = 0; i < n; i++) 
    totalsum += nums[i];
  
        boolean dp[][]=new boolean[n][totalsum+1];
    
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        
        if(nums[0]<=totalsum)
            dp[0][nums[0]] = true;
        
        for(int ind = 1; ind<n; ind++)
        {
            for(int target= 1; target<=totalsum; target++)
            {
                boolean notTaken = dp[ind-1][target];
        
                boolean taken = false;
                    if(nums[ind]<=target)
                        taken = dp[ind-1][target-nums[ind]];
            
                dp[ind][target]= notTaken||taken;
            }
        }
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<=totalsum;i++)
        {
            if(dp[n-1][i]==true)
            {
               int diff = Math.abs(i -(totalsum - i));
                min=Math.min(min,diff);
            }
        }
        return min;
        
    }
}