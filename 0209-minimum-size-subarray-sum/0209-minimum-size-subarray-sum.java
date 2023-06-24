class Solution {
    public int minSubArrayLen(int target, int[] nums) {
    int start = 0, n = nums.length, min = Integer.MAX_VALUE,sum = 0;
    for(int i = 0; i < n; i++)
    {
        sum += nums[i];
        while(sum >= target)
        {
            min = Math.min(min, i + 1 - start);
            sum -= nums[start];
            start++;
        }
    }
    if(min > n)
        return 0;
        
        return min;
    }
}