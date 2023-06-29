class Solution {
    public int maxSubArray(int[] nums) {
      int maxend=nums[0],res=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            maxend=Math.max(nums[i],maxend+nums[i]);
            res=Math.max(res,maxend);
        }
        return res;
    }
}