class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int totalsum = 0;
    for(int i=0; i<n;i++)
        totalsum += nums[i];
        
    //Checking for edge cases
    if(totalsum-target <0 || (totalsum-target)%2==1 )
        return 0;
    
    return findWays(nums,(totalsum-target)/2);
    }
static int findWays(int []nums, int target){
        int n=nums.length;
        int dp[][]=new int[n][target+1];
        
        if(nums[0]==0)
            dp[0][0]=2;    //pick and nonpick
        else
            dp[0][0]=1;
        
        if(nums[0]!=0 && nums[0]<=target)
            dp[0][nums[0]]=1;
        
        for(int i=1;i<n;i++)
        {
            for(int tar=0;tar<=target;tar++)
            {
                int nottaken=dp[i-1][tar];
                int taken=0;
                if(nums[i]<=tar)
                    taken=dp[i-1][tar-nums[i]];
                
                dp[i][tar]=taken+nottaken;
            }
        }
        return dp[n-1][target];
    }
}