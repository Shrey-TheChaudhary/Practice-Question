class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3;
        int coins = 0;
        
        for (int i = piles.length - 2; i >= n; i -= 2) {
            coins += piles[i];
        }
        
        return coins;
    }
}