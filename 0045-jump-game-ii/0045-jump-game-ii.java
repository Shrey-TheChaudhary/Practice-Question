class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
      int jumps = 0, currEnd = 0, currFarthest = 0;
      for(int i = 0; i < n-1; i ++) 
      {
          currFarthest = Math.max(currFarthest, i + nums[i]);
          if(i == currEnd) 
          {
              currEnd = currFarthest;
              jumps ++;
          }
      }  
      return jumps;
    }
}