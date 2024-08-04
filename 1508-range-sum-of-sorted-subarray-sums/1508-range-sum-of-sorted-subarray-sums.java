// class Solution {
//     public int rangeSum(int[] nums, int n, int left, int right) {
//         List<Integer> arr = new ArrayList<>();
//         for (int i = 0; i < n; i++) 
//         {
//             int prefix = 0;
//             for (int j = i; j < n; j++)
//             {
//                 prefix += nums[j];
//                 arr.add(prefix);
//             }
//         }
        
//         Collections.sort(arr);
//         int result = 0;
//         int MOD = 1000000007;
        
//         for (int i = left - 1; i < right; i++) 
//             result = (result + arr.get(i)) % MOD;
        
//         return result;
//     }
// }

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] arr = new int[n * (n + 1) / 2];
        for (int i = 0, k = 0; i < n; ++i) {
            
            int prefix = 0;
            for (int j = i; j < n; ++j)
            {
                prefix += nums[j];
                arr[k++] = prefix;
            }
        }
        Arrays.sort(arr);
        int ans = 0;
        int mod =1000000007;
        
        for (int i = left - 1; i < right; ++i) 
            ans = (ans + arr[i]) % mod;
        
        return ans;
    }
}