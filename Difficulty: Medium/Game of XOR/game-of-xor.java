class Solution {
    public int subarrayXor(int[] arr) {
        // code here
          int n = arr.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (((i + 1) & 1) == 1 && ((n - i) & 1) == 1) {
                ans ^= arr[i];
            }
        }

        return ans;
    }
}