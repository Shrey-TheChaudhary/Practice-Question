class Solution {
    //Striver
    public int minDays(int[] bloomDay, int m, int k) {
         long val = (long) m * k;
        
        int n = bloomDay.length; // Size of the array
        if (val > n) 
            return -1; // Impossible case.
        
        // Find maximum and minimum:
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int x:bloomDay) {
            mini = Math.min(mini,x);
            maxi = Math.max(maxi,x);
        }

        // Apply binary search:
        int low = mini, high = maxi;
        while (low <= high) 
        {
            int mid = (low + high) / 2;
            if (possible(bloomDay, mid, m, k)) 
                high = mid - 1;
             else 
                low = mid + 1;
        }
        return low;
    }
      public static boolean possible(int[] bloomDay, int day, int m, int k) 
      {
        int n = bloomDay.length; // Size of the array
        int count = 0;
        int bouquets  = 0;
        // Count the number of bouquets:
        for (int i = 0; i < n; i++) 
        {
            if (bloomDay[i] <= day)
                count++;
            
             else 
             {
                bouquets  += (count / k);
                count = 0;
            }
        }
        bouquets  += (count / k);
        return bouquets  >= m;
    }
}