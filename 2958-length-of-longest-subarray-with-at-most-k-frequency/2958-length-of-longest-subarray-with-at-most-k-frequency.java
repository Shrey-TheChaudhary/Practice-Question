import java.util.*;

public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, ans = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        while (r < n) {
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);
            while (l <= r && freq.get(nums[r]) > k) {
                freq.put(nums[l], freq.get(nums[l]) - 1);
                if (freq.get(nums[l]) == 0) {
                    freq.remove(nums[l]);
                }
                l++;
            }
            ans = Math.max(ans, r++ - l + 1);
        }

        return ans;
    }
}