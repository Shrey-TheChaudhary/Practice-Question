class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        int n=nums.length;
        int countZeroes=0,ans=Integer.MIN_VALUE;

        while(j<n) {
            if(nums[j]==0) 
                countZeroes++;
            
            while(countZeroes>k)
            {
                if(nums[i]==0) 
                    countZeroes--;
                
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;

    }
}