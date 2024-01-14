class Solution {
    public boolean closeStrings(String s, String t) {
        int n=s.length(),m=t.length();
        if(n!=m)
            return false;
        
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++)
        {
        hm1.put(s.charAt(i),hm1.getOrDefault(s.charAt(i), 0)+1);
        hm2.put(t.charAt(i), hm2.getOrDefault(t.charAt(i), 0)+1);
        }        
        
        for(int j= 0 ; j < m ;j++ )
        {
            if(!hm1.containsKey(t.charAt(j)))
                return false;
            
            if(!hm2.containsKey(s.charAt(j)))
                return false;
            
        }
        ArrayList<Integer> list1 = new  ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        for(Map.Entry<Character,Integer> e : hm1.entrySet())
            list1.add(e.getValue());
        
        for(Map.Entry<Character,Integer> e : hm2.entrySet())
            list2.add(e.getValue());
        
                                                                 
        Collections.sort(list1);
        Collections.sort(list2);
                                                                 
        return list1.equals(list2); 
    }
}