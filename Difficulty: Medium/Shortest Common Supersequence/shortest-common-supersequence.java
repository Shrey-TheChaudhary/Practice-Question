class Solution {
    public static int minSuperSeq(String s1, String s2) {
        // code here
         int n1 = s1.length();
        int n2 = s2.length();
        
        int[][] dp = new int[n1 + 1][n2 + 1];
        
        for(int i=n1 - 1; i>=0; i--) {
            for(int j=n2 - 1; j>=0; j--) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        
        int lcs = dp[0][0];
        
        return n1 + n2 - lcs;
    }
}