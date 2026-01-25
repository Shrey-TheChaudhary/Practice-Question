class Solution {
    int ans = 0;
    void f(int open, int close, int k) {
        if(open == k && close == k) {
            ans++;
            return;
        }
        if(open < k) {
            f(open + 1, close, k);
        }
        if(close < open) {
            f(open, close + 1, k);
        }
    }
    int findWays(int n) {
        // code here
        if(n % 2 != 0) return ans;
        
        f(0, 0, n / 2);
        return ans;
    }
}