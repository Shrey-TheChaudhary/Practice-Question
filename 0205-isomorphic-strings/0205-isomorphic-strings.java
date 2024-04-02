class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length())
            return false;
 
        int[] map1 = new int[256];
        int[] map2 = new int[256];
      
        for(int idx = 0; idx < s.length(); idx++)
        {
            if(map1[s.charAt(idx)] != map2[t.charAt(idx)])
                return false;
                
            map1[s.charAt(idx)] = idx + 1;
            map2[t.charAt(idx)] = idx + 1;
        }
        return true;   
    }
}