class Solution {
    public int missingNumber(int[] nums) {
        int sum_range = 0;
        int sum_org = 0;
        //Total sum
        for(int i =0;i<=nums.length;i++)
            sum_range += i;
        //sum of array
        for(int j =0;j<nums.length;j++)
            sum_org += nums[j];
        
        return sum_range - sum_org;
        
    }
}