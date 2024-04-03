class Solution {
    public int lengthOfLongestSubstring(String s) {
//         int n = s.length();
//         int maxLength = 0;
        
//         HashSet<Character> hs = new HashSet<>();
//         int i = 0;
        
//         for (int j = 0; j < n; j++) 
//         {
//             if (!hs.contains(s.charAt(j))) 
//             {
//                 hs.add(s.charAt(j));
//                 maxLength = Math.max(maxLength, j - i + 1);
//             }
//             else 
//             {
//                 while (hs.contains(s.charAt(j))) 
//                 {
//                     hs.remove(s.charAt(i));
//                     i++;
//                 }
//                 hs.add(s.charAt(j));
//             }
//         }
//         return maxLength;
        
        HashMap <Character,Integer> hm =new HashMap <Character,Integer>();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        
        while (right < n) 
        {
            if (hm.containsKey(s.charAt(right))) 
                left = Math.max(hm.get(s.charAt(right)) + 1, left);

            hm.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
     } 
}
