class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0, j=0;
        for(int k=0; k<t.length(); k++)
        {
            if(i<s.length())
            {
                if(s.charAt(i) == t.charAt(j))
                {
                    i++;
                    j++;
                }else
                    j++;
            }
        }
        return i == s.length();
    }
}