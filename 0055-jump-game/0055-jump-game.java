class Solution {
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        int maxReach = 0; 
        
        for (int i = 0; i <= maxReach; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            
            if (maxReach >= last) {
                return true; 
            }
        }
        
        return false;
    }
}