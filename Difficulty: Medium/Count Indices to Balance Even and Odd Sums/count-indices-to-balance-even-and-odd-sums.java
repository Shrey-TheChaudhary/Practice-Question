class Solution {
    public int cntWays(int[] arr) {
        // code here
           int n = arr.length;
        
        int[] prefixEven = new int[n];
        int[] prefixOdd = new int[n];
        
        // Build prefix sums
        if (n > 0) prefixEven[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixEven[i] = prefixEven[i-1];
            prefixOdd[i] = prefixOdd[i-1];
            if (i % 2 == 0) prefixEven[i] += arr[i];
            else prefixOdd[i] += arr[i];
        }
        
        int totalEven = prefixEven[n-1];
        int totalOdd = prefixOdd[n-1];
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int evenBefore = (i > 0) ? prefixEven[i-1] : 0;
            int oddBefore  = (i > 0) ? prefixOdd[i-1] : 0;
            
            int evenAfter = totalOdd - prefixOdd[i];
            int oddAfter  = totalEven - prefixEven[i];
            
            int newEvenSum = evenBefore + evenAfter;
            int newOddSum  = oddBefore + oddAfter;
            
            if (newEvenSum == newOddSum) count++;
        }
        
        return count;
    }
}
