import java.util.*;
class Solution {
    public int lengthOfLastWord(String s) {
        List<String> ls=new ArrayList<String>(); 
         StringTokenizer st = new StringTokenizer(s);
       while (st.hasMoreTokens())
       {
           ls.add(st.nextToken());
       }
        return ls.get(ls.size()-1).length();
    }
}