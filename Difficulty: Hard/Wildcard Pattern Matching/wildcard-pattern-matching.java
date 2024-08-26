//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int wildCard(String pattern, String str) {
        int n=pattern.length(), m=str.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 && j==0)    dp[i][j]=1;
                else if(i==0)   dp[i][j]=0;
                else if(j==0)   dp[i][j] = (pattern.charAt(i-1)=='*' && dp[i-1][j]==1 ? 1: 0);
                else if(pattern.charAt(i-1)==str.charAt(j-1))    dp[i][j] = dp[i-1][j-1];
                else if(pattern.charAt(i-1)=='?')     dp[i][j] = dp[i-1][j-1];
                else if(pattern.charAt(i-1)=='*')   dp[i][j] = (dp[i-1][j]==1 || dp[i][j-1]==1 ? 1:0);
            }
        }
        return dp[n][m];
    }
}