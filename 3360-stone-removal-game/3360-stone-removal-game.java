class Solution {
    public boolean canAliceWin(int n) {
        boolean count = false;
        int pile = 10;

        while (n >= pile) {
            n -= pile;
            pile--;
            count=!count;
        }

        return count;
    }
}