class Solution {
    public int firstUniqChar(String s) {
        // int freq[]=new int[26];
        // for(int i=0;i<s.length();i++)
        // {
        //     int ch=s.charAt(i)-'a';
        //     freq[ch]++;
        // }
        // for(int i=0;i<s.length();i++)
        // {
        //     int ch=s.charAt(i)-'a';
        //     if(freq[ch]==1)
        //         return i;
        // }
        // return -1;
        int m=0;
        for(int i : s.toCharArray()) {
            
            if(s.indexOf(i) == s.lastIndexOf(i)){
                return m;
            }
            m++;
        }
        return -1;

    }
}