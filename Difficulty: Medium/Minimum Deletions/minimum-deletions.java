class Solution {
    static int minDeletions(String s) {
        // code here
        int n = s.length();

        // dp[i][j] will store the length of longest palindromic subsequence in s[i...j]
        int[][] dp = new int[n][n];

        // Step 1: Every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Step 2: Fill the dp table for substrings of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // j is the end index of the substring

                // Case 1: Characters match at both ends
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = 2; // Two matching characters form a palindrome of length 2
                    } else {
                        dp[i][j] = 2 + dp[i + 1][j - 1]; // Expand the inner palindrome
                    }
                } 
                // Case 2: Characters don't match — take the max of removing one character
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 3: Longest Palindromic Subsequence = dp[0][n-1]
        int lpsLength = dp[0][n - 1];

        // Minimum deletions = total length - LPS
        return n - lpsLength;
    }
}