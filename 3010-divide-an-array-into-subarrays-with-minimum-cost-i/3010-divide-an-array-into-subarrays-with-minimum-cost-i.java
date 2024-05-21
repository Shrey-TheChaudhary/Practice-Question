class Solution {
  public int minimumCost(int[] nums) {
    final int n = nums.length;
    int[] left = Arrays.copyOfRange(nums, 1, n);
    Arrays.sort(left);

    return left[0] + left[1] + nums[0];
  }
}
