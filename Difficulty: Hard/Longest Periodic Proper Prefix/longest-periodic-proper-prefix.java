class Solution {
    int getLongestPrefix(String s) {
        int n = s.length();
        if (n <= 1) return -1;

        // Build LPS (KMP prefix function)
        int[] lps = new int[n];
        int len = 0;
        for (int i = 1; i < n; i++) {
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = lps[len - 1];
            }
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
            }
        }

        // Traverse borders (proper prefix == suffix lengths)
        int j = lps[n - 1];
        if (j == 0) return -1;

        int minBorder = Integer.MAX_VALUE;
        while (j > 0) {
            minBorder = Math.min(minBorder, j);
            j = lps[j - 1];
        }

        if (minBorder == Integer.MAX_VALUE) return -1;
        int ans = n - minBorder;
        return ans > 0 ? ans : -1;
    }
}