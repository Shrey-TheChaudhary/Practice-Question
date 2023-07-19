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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	   int n=str1.length();
        int m=str2.length();
        int k=lcs(str1,str2);
        
        return (n-k)+(m-k);  
    }
     public int lcs(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        
        int dp[][]=new int [n+1][m+1];
        
        for(int i=0;i<=n;i++)
            dp[i][0]=0;
        for(int i=0;i<=m;i++)
            dp[0][i]=0;
        
        for(int ind1=1;ind1<=n;ind1++)
        {
            for(int ind2=1;ind2<=m;ind2++)
            {
                if(text1.charAt(ind1-1)==text2.charAt(ind2-1))
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2]=0+Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
        return  dp[n][m];
    }
}