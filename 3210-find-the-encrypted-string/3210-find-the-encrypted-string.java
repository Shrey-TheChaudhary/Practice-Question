class Solution {
    public String getEncryptedString(String s, int k) {
        StringBuilder encryptedString = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int j = (i + k) % n;
            encryptedString.append(s.charAt(j));
        }
        return encryptedString.toString();
    }
}