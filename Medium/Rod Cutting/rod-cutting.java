//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int cuts[], int n) {
          int dp[][]=new int [n][n+1];
        
        for(int row[]:dp)
            Arrays.fill(row,-1);
        
        for(int i=0;i<=n;i++)
            dp[0][i]=i*cuts[0];
        
        for(int ind=1;ind<n;ind++)
        {
            for(int len=0;len<=n;len++)
            {
                int nottaken=0+dp[ind-1][len];
                int taken=Integer.MIN_VALUE;
                
                int rodlen=ind+1;
                if(rodlen<=len)
                    taken=cuts[ind] + dp[ind][len-rodlen];
                
                dp[ind][len]=Math.max(taken,nottaken);
            }
        }
        return dp[n-1][n];
    }
}