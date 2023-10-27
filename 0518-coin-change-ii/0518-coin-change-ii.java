class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int [n][amount+1];
        
        for(int i=0;i<=amount;i++)
        {
            if(i%coins[0]==0)
                dp[0][i]=1;
        }
        
        for(int ind=1;ind<n;ind++)
        {
            for(int cap=0;cap<=amount;cap++)
            {
                int nottaken=0+dp[ind-1][cap];
                
                int taken=0;
                if(coins[ind]<=cap)
                    taken=dp[ind][cap-coins[ind]];
                
                dp[ind][cap]=nottaken+taken;
            }
        }
        return dp[n-1][amount];
    }
}