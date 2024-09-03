//Striver DP-54
 class Solution {
    static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        
        // Traverse the input array from right to left
        for (int ind = n - 1; ind >= 0; ind--) {
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            
            // Iterate through the next 'k' elements or remaining elements if less than 'k'.
            for (int j = ind; j < Math.min(ind + k, n); j++) {
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = len * maxi + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[ind] = maxAns;
        }
        return dp[0];
    }
 }



//---------recurssion---------
// class Solution {
//     public int maxSumAfterPartitioning(int[] arr, int k) 
//     {
//          return f(0, arr, k);
//     }
//     static int f(int ind, int[] arr, int k) {
//         int n = arr.length;
        
//         if (ind == n) 
//             return 0;

//         int len = 0;
//         int maxi = Integer.MIN_VALUE;
//         int maxAns = Integer.MIN_VALUE;
        
//         // Iterate through the next 'k' elements or remaining elements if less than 'k'.
//         for (int j = ind; j < Math.min(ind + k, n); j++) {
//             len++;
//             maxi = Math.max(maxi, arr[j]);
//             int sum = len * maxi + f(j + 1, arr, k);
//             maxAns = Math.max(maxAns, sum);
//         }
//         return maxAns;
//     }
// }