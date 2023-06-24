class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        
        HashSet<Character> hs = new HashSet<>();
        int i = 0;
        
        for (int j = 0; j < n; j++) 
        {
            if (!hs.contains(s.charAt(j))) 
            {
                hs.add(s.charAt(j));
                maxLength = Math.max(maxLength, j - i + 1);
            }
            else 
            {
                while (hs.contains(s.charAt(j))) 
                {
                    hs.remove(s.charAt(i));
                    i++;
                }
                hs.add(s.charAt(j));
            }
        }
        
        return maxLength;
    }
}
