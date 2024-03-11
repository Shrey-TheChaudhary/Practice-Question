class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        
        for (int i = 0; i < s.length(); i++) 
            freq[s.charAt(i) - 'a']++;
        
        String ans ="";

        for (int i = 0; i < order.length(); i++)
        {
            for (int j = 0; j < freq[order.charAt(i) - 'a']; j++) 
               ans=ans+order.charAt(i);
            
            freq[order.charAt(i) - 'a'] = 0;
        }

        for (int i = 0; i < 26; i++)
        {
            for (int j = 0; j < freq[i]; j++) 
                ans=ans+(char) ('a' + i);
        }
        return ans;
    }
}