class Solution {
//     public int rob(int[] arr) {
//         int n=arr.length;
//         if(n==0)
//             return 0;
        
//         int dp[] = new int[n+1];
//         dp[0]=0;
//         dp[1]=arr[0];
        
//         for(int i=1; i<n; i++)
//             dp[i+1]=Math.max(dp[i],dp[i-1]+arr[i]);
        
//         return dp[n];
//     }
    
     public int rob(int[] arr) {
         int n = arr.length;

        if (n == 1) 
            return arr[0];

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i=2; i<n;i++) 
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);

        return dp[n - 1];        
    }
}