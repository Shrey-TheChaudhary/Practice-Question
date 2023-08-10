//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends




class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
       int dp[][]=new int[x+1][y+1];
       
       for(int i =0; i<=x;i++)
         dp[i][0] =0;
        
        for(int j =0; j<=y;j++)
         dp[0][j] =0;
         
         for(int ind1=1;ind1<=x;ind1++)
         {
              for(int ind2=1;ind2<=y;ind2++)
              {
                  if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                  dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                  
                  else
                  dp[ind1][ind2]=0+Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
              }
         }
         return dp[x][y];
    }
    
}