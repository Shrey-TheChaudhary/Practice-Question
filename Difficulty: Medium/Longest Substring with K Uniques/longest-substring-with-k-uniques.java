class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        Map<Character,Integer> map = new HashMap<>();
        int i=0 , j=0,res =-1,countK=0;
        int n = s.length();
        while(j<n)
        {
            char ch = s.charAt(j);
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)+1);
            }
            else
            {
                countK++;
                map.put(ch,1);
            }
            
            if(countK<k)
            j++;
            else if(countK == k){
            res = Math.max(res,j-i+1);
            j++;
            }
            else //countK>k
            {
                while(countK>k)
                {
                    int count = map.get(s.charAt(i));
                    if(count==1)
                    {
                        countK--;
                        map.remove(s.charAt(i));
                    }
                    else
                    map.put(s.charAt(i),count-1);
                    
                    i++;
                }
                j++;
            }
        }
        return res;
    }
}