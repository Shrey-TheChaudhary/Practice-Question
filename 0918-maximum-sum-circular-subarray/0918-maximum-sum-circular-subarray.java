class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxnormal = kadane(nums);
        if(maxnormal<0)
            return maxnormal;
        
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i]; 
        }


        int maxcircular = totalSum+kadane(nums);
        return Math.max(maxcircular,maxnormal);
    }

    public int kadane(int[] a) {
        int res = a[0], maxsum=a[0];
        for (int i=1;i<a.length;i++)
        {
        maxsum=Math.max(a[i],maxsum+a[i]);
            res=Math.max(maxsum,res);
        }

        return res;
    }
}