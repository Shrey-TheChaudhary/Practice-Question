class Solution {
  private int dfs(int[] nums, int k, int i, Set<Integer> hs) {
    if (i == nums.length)
     return hs.isEmpty() ? 0 : 1;

    var cnt = dfs(nums, k, i+1, hs);
    
    if (hs.contains(nums[i] - k)) return cnt;

    hs.add(nums[i]);
    cnt += dfs(nums, k, i+1 ,hs);
    hs.remove(nums[i]);

    return cnt;
  }

  public int beautifulSubsets(int[] nums, int k) {
    Arrays.sort(nums);

    return dfs(nums, k, 0, new HashSet<Integer>());
  }
}