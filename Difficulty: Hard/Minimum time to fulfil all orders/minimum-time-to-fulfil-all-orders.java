import java.util.*;

class Solution {
    public int minTime(int[] ranks, int n) {
        int low = 0;
        int high = 100000000; 
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(ranks, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] ranks, int n, int midTime) {
        long totalDonuts = 0;

        for (int r : ranks) {
            int count = 0;
            int timeUsed = 0;
            int nextDonutTime = r;
            
            while (timeUsed + nextDonutTime <= midTime) {
                timeUsed += nextDonutTime;
                count++;
                nextDonutTime += r;
            }
            
            totalDonuts += count;
            if (totalDonuts >= (long)n) return true;
        }

        return totalDonuts >= (long)n;
    }
}

