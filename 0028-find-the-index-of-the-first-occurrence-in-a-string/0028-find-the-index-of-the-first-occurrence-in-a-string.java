class Solution {
    public int strStr(String haystack, String needle)
    {
        int n=haystack.length();
        int m=needle.length();
        
        for(int i=0;i<=n-m;i++)
        { 
            int c=0;
            for(int j=0;j<m;j++)
            if(haystack.charAt(i+j)==needle.charAt(j))
                c++;
            if(c==m)
             return i;
        }
        return -1;
    }
}