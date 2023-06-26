class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        
        for(int i:nums)
            hs.add(i);
        
        int res=0;
        for(Integer x:nums)
        {
            if(hs.contains(x-1)==false)
            {
                int curr=1;
                while(hs.contains(x+curr))
                    curr++;
                
                res=Math.max(curr,res);
            }
        }
        return res;
    }
}