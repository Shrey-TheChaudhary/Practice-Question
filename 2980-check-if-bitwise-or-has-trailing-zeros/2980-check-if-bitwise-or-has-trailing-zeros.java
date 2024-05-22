class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int count = 0;
        for (int x : nums) {
            count += (x & 1 ^ 1);
        }
        return count >= 2;
    }
}