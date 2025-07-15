class Solution {
    public boolean divby13(String s) {
        // code here
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            result = (result * 10 + digit) % 13;
        }
        return result == 0;
    }
}