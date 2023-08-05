import java.util.*;
class Solution {
    public String reverseWords(String s) {
         String res="";
         StringTokenizer st = new StringTokenizer(s);
       while (st.hasMoreTokens())
       {String ans="";
           String str=st.nextToken();
           for(int i=0;i<str.length();i++)
           {
               ans=str.charAt(i)+ans;
           }
           res+=ans+" ";
       }
     return res.trim();
    }
}