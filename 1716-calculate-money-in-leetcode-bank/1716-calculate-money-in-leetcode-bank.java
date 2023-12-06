class Solution {
    public int totalMoney(int n) {
        int w = n / 7, m = n % 7;
        return 7*((w*(w+1)/2) + 3*w) + (m*(m+1)/2) + m*w;
    }
}