//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String S) {
        //your code here
        int n = S.length();
        int[] dp = new int[n+1];
        for(int i = 1; i<=n; i++){
            int[] temp = new int[n+1];
            for(int j = 1; j<=n; j++){
                if(S.charAt(i-1) == S.charAt(n-j))
                    temp[j] = 1 + dp[j-1];
                else
                    temp[j] = Math.max(dp[j], temp[j-1]);
            }
            dp = temp;
        }
        return n - dp[n];
    }
}