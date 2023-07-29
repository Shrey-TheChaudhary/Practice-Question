class Solution {
    public String reverseVowels(String s) {
        String rev="";
        String ans="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'|| ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            rev=ch+rev;
        }
        int a=0;
         for(int i=0;i<s.length();i++)
        {
             char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'|| ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
                ans+=rev.charAt(a++);
             else
             ans+=s.charAt(i);
         }
        return ans;
             
    }
}