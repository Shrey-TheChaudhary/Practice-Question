class Solution {
    public String compressedString(String word) {
        
        StringBuilder comp = new StringBuilder();
        int i = 0;
        while (i < word.length())
        {
            char ch = word.charAt(i);
            int cnt = 0;

            while (i < word.length() && word.charAt(i) == ch && cnt < 9) {
                i++;
                cnt++;
            }
                   
            comp.append(cnt).append(ch);
        }
        return comp.toString();
    }
}