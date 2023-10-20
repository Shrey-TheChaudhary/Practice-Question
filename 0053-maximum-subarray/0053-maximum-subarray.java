class Solution {
    public int maxSubArray(int[] nums) {
      // int maxend=nums[0],res=nums[0];
      //   for(int i=1;i<nums.length;i++)
      //   {
      //       maxend=Math.max(nums[i],maxend+nums[i]);
      //       res=Math.max(res,maxend);
      //   }
      //   return res;
        
            int max=Integer.MIN_VALUE;
            int currsum=0;
            for(int i=0;i<nums.length;i++)
            {
            currsum+=nums[i];
            if(currsum>max)
            max=currsum;
                
            if(currsum<0)
            currsum=0;
            
            }
            return max;

    }
}