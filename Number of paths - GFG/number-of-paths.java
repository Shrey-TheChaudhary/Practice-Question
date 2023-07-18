//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int m = Integer.parseInt(inputLine[0]);
		    int n = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(m, n));
		}
	}
}




// } Driver Code Ends


class Solution{
    
    long numberOfPaths(int m, int n) {
       long dp[][]=new long [m][n];
        for(long row[]:dp)
            Arrays.fill(row,-1);
        
        return countway(m,n,dp);
    }
        long countway(int m,int n,long dp[][])
        {
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
            if(i==0 && j==0)
            {
                dp[i][j]=1;
                continue;
            }
                long up=0,left=0;
                if(i>0)
                    up=dp[i-1][j];
                if(j>0)
                    left=dp[i][j-1];
                
                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }
}