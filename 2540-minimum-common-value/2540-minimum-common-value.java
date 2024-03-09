public class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            if (search(nums2, nums1[i])) {
                return nums1[i];
            }
        }
        return -1;
    }
}