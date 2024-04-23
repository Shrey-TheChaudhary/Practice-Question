class Solution {
    public int rob(int[] nums) {
        if(nums.length<2)
            return nums[0];

        int []skipLastHouse = new int[nums.length];
        int []skipFirstHouse = new int[nums.length];

        for(int i = 0;i<nums.length-1;i++){
            skipLastHouse[i]=nums[i];
            skipFirstHouse[i]=nums[i+1];
        }

        int skippingLast = robberHelp(skipLastHouse);
        int skippingFirst = robberHelp(skipFirstHouse);

        return Math.max(skippingLast,skippingFirst);

    }
    private int robberHelp(int[]nums){
        int [] dp = new int [nums.length];

        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i = 2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);

        }
        return dp[nums.length-1];
    }
}