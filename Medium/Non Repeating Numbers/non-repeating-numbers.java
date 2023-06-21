//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends



//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    { 
        int n=nums.length;
       int xor=nums[0];
       for(int i=1;i<n;i++)
       xor=xor^nums[i];
       
       int res1=0,res2=0;
       int set=xor&~(xor-1);
       
       for(int i=0;i<n;i++)
       {
           if((nums[i]&set)!=0)
           res1=res1^nums[i];
           else
           res2=res2^nums[i];
       }
          if(res1 < res2) 
            nums = new int[]{res1, res2};
           
        else 
            nums = new int[]{res2, res1};
            
            return nums;
    }     
}