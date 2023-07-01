class Solution { 
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = Integer.MAX_VALUE; 
        while (l <= r) 
        {
            int mid = l + (r - l) / 2;
            if (helper(mid, nums) > threshold) 
                l = mid + 1;
             else 
                r = mid - 1;
        }
        return l;
    }
    public int helper(int mid, int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) 
            res += (nums[i] + mid - 1) / mid;
        
        return res;
    }
}