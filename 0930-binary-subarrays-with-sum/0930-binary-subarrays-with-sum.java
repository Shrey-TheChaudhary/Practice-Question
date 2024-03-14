class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int total = 0;
        int sum = 0;
        int presum[] = new int[nums.length + 1];
        presum[0] = 1;
        
        for (int num : nums) {
            sum += num;
            if (sum >= goal) {
                total += presum[sum - goal];
            }
            presum[sum]++;
        }
        
        return total;
    }
}