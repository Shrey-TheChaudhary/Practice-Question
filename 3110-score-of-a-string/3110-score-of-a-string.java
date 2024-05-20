class Solution {
    public int scoreOfString(String s) {
        int ans=0;
        for(int i=0;i<s.length()-1;i++)
        {
            int first=(int)s.charAt(i);
            int second=(int) s.charAt(i+1);
            int diff=Math.abs(first-second);
            ans+=diff;
        }
        return ans;
    }
}