class Solution {
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        int minprice = prices[0];
        int n = prices.length;
        for(int i = 0; i<n; i++){
            minprice = Math.min(minprice,prices[i]);
            int currprofit = prices[i]-minprice;
            maxprofit = Math.max(maxprofit,currprofit);
        }
        return maxprofit;
    }
}