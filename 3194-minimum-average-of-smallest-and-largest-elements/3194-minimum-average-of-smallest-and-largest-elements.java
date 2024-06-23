class Solution {
    public double minimumAverage(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        double ans=999999;

        for (int i = 0; i < n / 2; i++) 
        {
            double avg = (nums[i] + nums[n - 1 - i]) / 2.0;
            ans=Math.min(avg,ans);
        }

        return ans;
    
    }
}