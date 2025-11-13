class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int n = s1.length(), m = s2.length(), k = s3.length();
        
        if(n + m != k) return false;
        
        int j = 0;
        for(int i = 0; i < k && j < n;i++) {
            if(s1.charAt(j) == s3.charAt(i)) {
                j++;
            }
        }
        if(j != n) return false;
        j = 0;
        for(int i = 0; i < k && j < m;i++) {
            if(s2.charAt(j) == s3.charAt(i)) {
                j++;
            }
        }
        
        return j == m;
    }
}