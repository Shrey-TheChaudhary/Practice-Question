class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0;
        int n=nums.length;
        int countZeroes=0,ans=Integer.MIN_VALUE;

        while(r<n) {
            if(nums[r]==0) 
                countZeroes++;
            
            while(countZeroes>k)  //if(countZeros>k)   4ms
            {
                if(nums[l]==0) 
                    countZeroes--;
                
                l++;
            }
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;

    }
}