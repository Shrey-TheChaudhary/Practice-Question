class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if(Math.abs(nums[i]-nums[j])<=Math.min(nums[i],nums[j]))
                res=Math.max(res,nums[i]^nums[j]);
            }
        }
        return res;
    }
}