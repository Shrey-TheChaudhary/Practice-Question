class Solution {
    public int minDistance(String word1, String word2) {
         int n=word1.length();
        int m=word2.length();
        
        int  dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            dp[i][0]=i;
        for(int i=0;i<=m;i++)
            dp[0][i]=i;
        

        for(int ind1=1;ind1<=n;ind1++)
        {
            for(int ind2=1;ind2<=m;ind2++)
            {
                if(word1.charAt(ind1-1)==word2.charAt(ind2-1))
                    dp[ind1][ind2]=0+dp[ind1-1][ind2-1];
                else
                    // return 1+f(i-1,j) // Insertion of character.
                    // return 1+f(i,j-1) // Deletion of character.
                    // return 1+f(i-1,j-1) // Replacement of character.
                dp[ind1][ind2]=1+Math.min
                    (dp[ind1-1][ind2],Math.min(dp[ind1][ind2-1],dp[ind1-1][ind2-1]));
            }
        }
        return dp[n][m];
    }
}