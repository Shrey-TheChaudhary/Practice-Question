//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String s)
    {
         String rev=new StringBuilder(s).reverse().toString();
        int n=s.length();
        int m=rev.length();
        int len=lcs(s,rev);
        return n-len;
    }
    public static int lcs(String text1, String text2) {
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