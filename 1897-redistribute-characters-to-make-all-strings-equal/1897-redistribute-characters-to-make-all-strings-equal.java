import java.util.*;

class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> count = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
        }
        
        int n = words.length;
        for (Map.Entry<Character, Integer> entry : count.entrySet())        {
            if (entry.getValue() % n != 0) 
                return false;
            
        }
        
        return true;
    }
}