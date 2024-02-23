class Solution {
    public int findPoisonedDuration(int[] nums, int d) {
        int ans=d;
        
        for(int i=1;i<nums.length;i++)
            ans+=Math.min(d,nums[i]-nums[i-1]);
                          
        return ans;
    }
}