class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int totalsum = 0;
        int arrsum = 0;
        
        //Total sum
        // for(int i =0;i<=nums.length;i++)
        //     totalsum += i;
        
        totalsum=(n*(n + 1))/2;
        
        //sum of array
        for(int j =0;j<nums.length;j++)
            arrsum += nums[j];
        
        return totalsum - arrsum;
        
    }
}