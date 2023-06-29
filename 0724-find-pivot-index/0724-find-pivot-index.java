class Solution {
    public int pivotIndex(int[] nums) {
      if(nums.length == 0) 
          return - 1;
        
      int leftsum = 0, totalsum = 0;
        
      for(int num : nums) 
          totalsum += num;

      for(int i = 0; i < nums.length; i ++)
      {
        totalsum -= nums[i];
        if(totalsum == leftsum) 
            return i;
          
        leftsum += nums[i];
      }
      return - 1;
    }
}