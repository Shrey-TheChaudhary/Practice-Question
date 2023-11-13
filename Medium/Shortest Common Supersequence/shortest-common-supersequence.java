//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
public static int shortestCommonSupersequence(String X,String Y,int m,int n)  {
        int dp[] = new int[n+1],cur[] = new int[n+1];
        for(int i=1;i<=m;i++){ 
            for(int j=1;j<=n;j++)
                cur[j]=(X.charAt(i-1)==Y.charAt(j-1))?1+dp[j-1]:Math.max(dp[j],cur[j-1]);
            dp=cur.clone();
        } return m+n-dp[n];
    }
}