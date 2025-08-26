class Solution {
    public boolean isSubSeq(String s1, String s2) {
        // code here
        int index = 0;
        for(char ch : s2.toCharArray()) {
            if(s1.charAt(index) == ch) index++;
            if(index == s1.length()) return true;
        }
        return false;
    }
};