class Solution {
    public int maxProfit(int[] prices) {
        int maxp=0,mini=prices[0];
        
        for(int i=0;i<prices.length;i++)
        {
            int currprofit=prices[i]-mini;
            maxp=Math.max(currprofit,maxp);
            mini=Math.min(mini,prices[i]);
        }
        return maxp;
    }
}