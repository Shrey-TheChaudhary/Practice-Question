class Solution {
    public int[] runningSum(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        
        if(n==0)
            return ans;
        
        ans[0]=nums[0];
        for(int i=1;i<n;i++)
            ans[i]=nums[i]+ans[i-1];
        
        return ans;
    }
}