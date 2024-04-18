class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        int rsum = 0;
        int maxsum = 0;
        
        // Calculate the maximum score by selecting cards from the left side
        for (int i = 0; i < k; i++) {
            lsum += cardPoints[i];
            maxsum = Math.max(lsum, maxsum);
        }
        
        int r = cardPoints.length - 1;
        
        // Adjust the selection by moving one card from left to right
        // and simultaneously removing one card from right to left
        for (int i = k - 1; i >= 0; i--) {
            lsum -= cardPoints[i];
            rsum += cardPoints[r];
            r--;
            maxsum = Math.max(maxsum, lsum + rsum);
        }
      
        return maxsum;
    }
}