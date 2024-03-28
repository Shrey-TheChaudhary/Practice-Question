import java.util.*;

public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, right = 0, max_length = 0;

        while (right < nums.length)
        {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while (freq.get(nums[right]) > k)
            {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                left++;
            }

            max_length = Math.max(max_length, right - left + 1);
            right++;
        }

        return max_length;
    }
}