class Solution {
    public long countSubstrings(String s, char c) {
        long ans = 0;
        long count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) 
                count++;
        }
        ans= count*(count+1)/2;
        
        return ans;
        
    }
}
       