class Solution {
    public int minFlips(int a, int b, int c) {
        return Integer.bitCount(a & ~c) +  Integer.bitCount(~(a | b) & c) + Integer.bitCount(b & ~c);
    }
}