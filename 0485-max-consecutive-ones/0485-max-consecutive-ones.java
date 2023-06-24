class Solution {
    public int findMaxConsecutiveOnes(int[] nums) 
    {
        int max=0, ans=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                max++;
                ans=Math.max(ans,max);
            }
            else
                max=0;
        }
        return ans;
    }
}