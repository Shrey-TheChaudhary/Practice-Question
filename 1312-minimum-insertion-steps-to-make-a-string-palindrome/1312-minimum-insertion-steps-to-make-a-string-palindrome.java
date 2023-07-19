class Solution {
    public int minInsertions(String s) {
        String rev=new StringBuilder(s).reverse().toString();
        int n=s.length();
        int m=rev.length();
        int len=lcs(s,rev);
        return n-len;
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