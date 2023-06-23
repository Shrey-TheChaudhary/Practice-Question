import java.util.*;
class Solution {
    public String reverseWords(String s) {
         String ans="";
         StringTokenizer st = new StringTokenizer(s);
       while (st.hasMoreTokens())
       {
           ans=st.nextToken()+" "+ans;
       }
     return ans.trim();
    }
}