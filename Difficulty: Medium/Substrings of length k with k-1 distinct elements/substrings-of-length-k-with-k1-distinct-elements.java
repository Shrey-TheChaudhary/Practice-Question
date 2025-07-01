class Solution {
    public int substrCount(String s, int k) {
        // code here
        HashMap<Character,Integer>hm = new HashMap<>();
        for(int i=0;i<k;i++)
        {
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        int c=0;
        if(hm.size()==k-1)
        {
            c++;
        }
        for(int i=1;i<=s.length()-k;i++)
        {
            hm.put(s.charAt(i-1),hm.get(s.charAt(i-1))-1);
            if(hm.get(s.charAt(i-1))==0)
            hm.remove(s.charAt(i-1));
            hm.put(s.charAt(i+k-1),hm.getOrDefault(s.charAt(i+k-1),0)+1);
            if(hm.size()==k-1)
            {
                c++;
            }
        }
        return c;
    }
}