class Solution {
    public int maxJump(int[] stones) {
         int prev2=0;
        int prev1=stones[1]-stones[0];
        for(int i=2;i<stones.length;i++)
        {
            int jump=stones[i]-stones[i-2];
            prev2=prev1;
            prev1=Math.max(prev1,jump);
        }
        return prev1;
    }
}