class Solution {
    public int minFlips(int a, int b, int c) {
        //~means complement
        return Integer.bitCount(a & ~c) // 0010 & 1010-->1
            +  Integer.bitCount(~(a | b) & c) //(0010 | 0110)-> 0110-->~0110===1001 & 0101-->1
            + Integer.bitCount(b & ~c); //0110 & 1010-->1
        
        //1+1+1=3 Ans
    }
}