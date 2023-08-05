class Solution {
    public String reverseWords(String s) {
        String [] newString = s.split(" ");
       StringBuilder sb1 = new StringBuilder();
        
       for(String s1 : newString)
       {
           StringBuilder sb = new StringBuilder(s1);
           sb.reverse();
           sb1.append(" ").append(sb);
       }

return  sb1.toString().substring(1);
    }
}