class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int [n][amount+1];
        
        for(int i=0;i<=amount;i++)
        {
            if(i%coins[0]==0)
                dp[0][i]=i/coins[0];
            else
                dp[0][i]=(int)Math.pow(10,9);
        }
        for(int ind=1;ind<n;ind++)
        {
            for(int cap=0;cap<=amount;cap++)
            {
                int nottaken=0+dp[ind-1][cap];
                int taken=(int)Math.pow(10,9);
                
                if(coins[ind]<=cap)
                    taken=1+dp[ind][cap-coins[ind]];
                
                dp[ind][cap]=Math.min(taken,nottaken);
            }
        }
        int ans=dp[n-1][amount];
        
        if(ans>=(int)Math.pow(10,9))
            return -1;
        
            return ans;
    }
}