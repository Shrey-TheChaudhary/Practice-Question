class Solution {
    public int maxProduct(int[] nums) {
         int n = nums.length;
        Arrays.sort(nums);
        return (nums[n - 2] - 1) * (nums[n - 1] - 1);
    }
}