class Solution {
    public int minimumPushes(String word) {
        Map<Character,Integer> map=new HashMap<>();
        
        for(int i=0;i<word.length();i++)
            map.put(word.charAt(i),map.getOrDefault(word.charAt(i),0)+1);
        
        List<Integer> list=new ArrayList<>();
        for(char ch:map.keySet())
            list.add(map.get(ch));
        
        Collections.sort(list,Collections.reverseOrder());
        int ans=0,a=1;
        
        for(int i=0;i<list.size();i++){
            if(a<=8)
                ans+=list.get(i)*1;
            else if(a>8 && a<=16)
                ans+=list.get(i)*2;
            else if(a>16 && a<=24)
                ans+=list.get(i)*3;
            else
                ans+=list.get(i)*4;
            a++;
        }
        return ans;
    }
}