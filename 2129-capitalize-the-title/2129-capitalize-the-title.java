import java.util.*;
class Solution {
    public String capitalizeTitle(String title) {
         StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(title);

        while (tokenizer.hasMoreTokens()) 
        {
            String word = tokenizer.nextToken();
            if (word.length() <= 2) 
            {
                sb.append(word.toLowerCase());
            } else 
            {
                sb.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1).toLowerCase());
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}