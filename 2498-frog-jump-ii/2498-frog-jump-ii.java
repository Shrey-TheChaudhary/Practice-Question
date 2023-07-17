class Solution {
    public int maxJump(int[] stones) {
         int n=stones.length;
        int dp[] = new int[n+1];
        int left=0,right=0;
        for(int i=1;i<n;i++){
            left =Math.max(dp[i]+Math.abs(stones[i]-stones[i-1]),left);
            if(i>1)
            right=Math.max(dp[i]+Math.abs(stones[i]-stones[i-2]),right);
            dp[i]=Math.max(left,right);
            
        }
        return dp[n-1];
    }
}