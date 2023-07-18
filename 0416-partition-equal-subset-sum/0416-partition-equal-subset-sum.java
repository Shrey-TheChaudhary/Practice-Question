class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalsum=0;
        for(int i:nums)
            totalsum+=i;
        
        if(totalsum%2==1)
            return false;
        
        int target=totalsum/2;
        boolean  dp[][]=new boolean[n][target+1];
        
        return isSubsetSum(n,target,nums,dp);
    }
    static Boolean isSubsetSum(int N,int sum,int arr[],boolean dp[][])
    {
        for(int i=0;i<N;i++)
        dp[i][0]=true;
        
        if(arr[0]<=sum)
        dp[0][arr[0]]=true;
        
        for(int i=1;i<N;i++)
        {
            for(int target=1;target<=sum;target++)
            {
                boolean nottaken=dp[i-1][target];
                boolean taken=false;
                
                if(arr[i]<=target)
                taken=dp[i-1][target-arr[i]];
                
                dp[i][target]=nottaken||taken;
            }
        }
        return dp[N-1][sum];
    }
}