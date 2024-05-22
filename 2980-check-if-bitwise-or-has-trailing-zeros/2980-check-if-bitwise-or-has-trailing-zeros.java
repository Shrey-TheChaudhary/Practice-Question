class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        return Arrays.stream(nums).filter(num -> num % 2 == 0).count() > 1;
    }
}