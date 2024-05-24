public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        int[] lettersCount = new int[26];
        
        for (char c : letters) {
            count[c - 'a']++;
        }
        
        int ans = 0;
        ans = backtracking(words, score, count, lettersCount, 0, 0, ans);
        return ans;
    }
    
    private int backtracking(String[] words, int[] score, int[] count, int[] lettersCount, int pos, int temp, int ans) {
        for (int i = 0; i < 26; i++) {
            if (lettersCount[i] > count[i]) return ans;
        }
        
        ans = Math.max(ans, temp);
        
        for (int i = pos; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                lettersCount[c - 'a']++;
                temp += score[c - 'a'];
            }
            
            ans = backtracking(words, score, count, lettersCount, i + 1, temp, ans);
            
            for (char c : words[i].toCharArray()) {
                lettersCount[c - 'a']--;
                temp -= score[c - 'a'];
            }
        }
        
        return ans;
    }
}