class Solution {
    public boolean wildCard(String txt, String pat) {
        int dp[][] = new int[txt.length()][pat.length()];
        
        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }
        
        return helper(txt, pat, 0, 0, dp);
    }
    
    public boolean helper(String txt, String pat, int str, int iPat, 
    int[][] dp) {
        
        int txtLen = txt.length();
        int patLen = pat.length();
        
        if (str >= txtLen && iPat >= patLen) {
            return true;
        }
        
        if (iPat >= patLen) {
            return false;
        }
        
        if (str >= txtLen && iPat < patLen) {
            // check remaining pattern for all '*'s
            for (int i = iPat; i < patLen; i++) {
                if (pat.charAt(i) == '*') {
                    continue;
                }
                return false;
            }
            return true;
        }
        
        int tChar = txt.charAt(str);
        int pChar = pat.charAt(iPat);
        
        if (pChar != '*' && pChar != '?' && pChar != tChar) {
            return false;
        }
        
        if (dp[str][iPat] != -1) {
            return dp[str][iPat] == 1 ? true : false;
        }
        
        // simple match
        if (pChar == tChar) {
            return helper(txt, pat, str+1, iPat+1, dp);    
        }
        
        // single char match
        if (pChar == '?') {
            return helper(txt, pat, str+1, iPat+1, dp);
        }
        
        // multi-char match
        if (pChar == '*') {
            // match one char
            boolean res1 = helper(txt, pat, str+1, iPat+1, dp);
            if (res1) {
                dp[str][iPat] = 1;
                return true;
            }
            // match multiple
            boolean res2 = helper(txt, pat, str+1, iPat, dp);
            if (res2) {
                dp[str][iPat] = 1;
                return true;
            }
            // match none
            boolean res3 = helper(txt, pat, str, iPat+1, dp);
            if (res3) {
                dp[str][iPat] = 1;
                return true;
            }
        }
        
        dp[str][iPat] = 0;
        return false;
    }
}