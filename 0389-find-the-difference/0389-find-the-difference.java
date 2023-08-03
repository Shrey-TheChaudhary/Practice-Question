class Solution {
    public char findTheDifference(String s, String t) {
//         int[] dict = new int[26];
//         for (char ch : s.toCharArray()) {
//             dict[ch - 'a']++;
//         }
//         for (char ch : t.toCharArray()) {
//             dict[ch - 'a']--;
//         }
//         for (int i = 0; i < dict.length; i++) {
//             if (dict[i] < 0) {
//                 return (char)('a' + i);
//             }
//         }
//         return ' ';
        
        char c = 0;
        for(char cs : s.toCharArray()) 
            c ^= cs;
        for(char ct : t.toCharArray()) 
            c ^= ct;
        
        return c;
    }
}