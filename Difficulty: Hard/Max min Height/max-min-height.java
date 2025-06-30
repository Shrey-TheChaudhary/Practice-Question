class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int a : arr) {
            low = Math.min(low, a);
            high = Math.max(high, a);
        }
        high += k; // max possible increase

        int result = low;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canReach(arr, k, w, mid)) {
                result = mid;
                low = mid + 1; // try for a higher minimum
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private boolean canReach(int[] arr, int k, int w, int target) {
        int n = arr.length;
        int[] diff = new int[n + 2];
        long used = 0;
        long curr = 0;

        for (int i = 0; i < n; i++) {
            curr += diff[i]; // accumulated increment at i
            long height = arr[i] + curr;
            if (height < target) {
                long need = target - height;
                used += need;
                if (used > k) return false;
                curr += need;
                diff[i] += need;
                if (i + w < diff.length) diff[i + w] -= need;
            }
        }
        return true;
    }
}