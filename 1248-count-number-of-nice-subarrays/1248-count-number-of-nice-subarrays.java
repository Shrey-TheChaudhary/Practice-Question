class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k)- helper(nums, k-1);
    }
    public static int helper(int nums[], int k){
        int sum =0;
        int l = 0;
        int r=0;
        int ans = 0;
        while(r<nums.length){
            if(nums[r]%2==1)
                sum++;

            while(sum>k){
                if(nums[l]%2==1) 
                    sum--;
                l++;
            }

            ans+=(r-l+1);
            r++;
        }
        return ans;
    }
}
