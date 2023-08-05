class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max=0;
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        for(int key:map.keySet()) 
        {    
            if(map.containsKey(key+1))
            {
                max=Math.max(max,map.get(key)+map.get(key+1));            
            }
        }
        return max;
    }
}