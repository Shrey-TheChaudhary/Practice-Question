class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxDifficulty = 0;
        
        for (int d : difficulty) 
            maxDifficulty = Math.max(maxDifficulty, d);
        

        int[] maxprofit = new int[maxDifficulty + 1];
        
        for (int i = 0; i < difficulty.length; i++)
        {
            maxprofit[difficulty[i]] = Math.max(maxprofit[difficulty[i]], profit[i]);
        }

        for (int i = 1; i <= maxDifficulty; i++) {
            maxprofit[i] = Math.max(maxprofit[i], maxprofit[i - 1]);
        }

        int totalProfit = 0;
        for (int ability : worker) {
            if (ability > maxDifficulty) {
                totalProfit += maxprofit[maxDifficulty];
            } else {
                totalProfit += maxprofit[ability];
            }
        }

        return totalProfit;
    }

}