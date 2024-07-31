class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return arrangeBooks(books, shelfWidth);
    }

    private int arrangeBooks(int[][] books, int maxWidth) {
        int[] dp = new int[books.length + 1];
        
        for (int i = 1; i <= books.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            int shelfHeight = 0;
            int shelfWidth = 0;
            
            for (int j = i - 1; j >= 0; j--) {
                int bookWidth = books[j][0];
                int bookHeight = books[j][1];
                
                if (shelfWidth + bookWidth > maxWidth) {
                    break;
                }
                
                shelfWidth += bookWidth;
                shelfHeight = Math.max(shelfHeight, bookHeight);
                
                int height = dp[j] + shelfHeight;
                dp[i] = Math.min(dp[i], height);
            }
        }
        
        return dp[books.length];
    }
}
