class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
       int n=str1.length();
        int m=str2.length();
        
        int  dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            dp[i][0]=0;
        for(int i=0;i<=m;i++)
            dp[0][i]=0;
        
        for(int ind1=1;ind1<=n;ind1++)
        {
            for(int ind2=1;ind2<=m;ind2++)
            {
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1))
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2]=0+Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
        
        int len=dp[n][m];
        int i=n,j=m;
       StringBuilder sb = new StringBuilder();
        while(i>0 && j>0)
        {
            if(str1.charAt(i-1)==str2.charAt(j-1))
            {
               sb.append(str1.charAt(i-1));
                i--;
                j--;
                
            }
            else if(dp[i-1][j]>dp[i][j-1])
            {
               sb.append(str1.charAt(i-1));
                i--;
            }
            else{
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i>0)
        {
           sb.append(str1.charAt(i-1));
                i--;
        }
        while(j>0)
        {
           sb.append(str2.charAt(j-1));
                j--;
        }
        return sb.reverse()+"";
    }
}