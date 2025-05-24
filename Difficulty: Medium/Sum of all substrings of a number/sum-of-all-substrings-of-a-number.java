class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int ans = 0 , n = s.length();
        for(int i = 0 ; i < n ; i++){
            ans += helper(s,i,"");
        }
        return ans;
    }
    public static int helper(String s, int idx , String subString){
        if(idx == s.length()) return 0;
        subString = new StringBuilder(subString).append(s.charAt(idx)).toString();
        return Integer.parseInt(subString)+helper(s,idx+1,subString);
    }
}