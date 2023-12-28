class Solution {
    public int findComplement(int num) {
        int n=Integer.toBinaryString(num).length();
        int h= (1 << n) - 1;
        return h ^ num;//XOR
    }
}


