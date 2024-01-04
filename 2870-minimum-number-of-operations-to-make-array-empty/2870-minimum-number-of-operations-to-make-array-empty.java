class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        
        int ans=0;
        for(int it: hm.keySet()){
            int freqOfKey=hm.get(it);
            if (freqOfKey == 1) {
                return -1;
            }
            ans+=Math.ceil((double)freqOfKey/3);
        }
        return ans;       
    }
}