class Solution {
 public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int num : nums) {
            low = Math.max(low,num);
            high += num;
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isSplittable(nums,mid,k)) 
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return low;
    }
    
    public boolean isSplittable(int[] nums,int maxSum,int k) {
       int currentSum = 0 , count = 1;
       for(int num : nums) 
       {
           currentSum += num;
           if(currentSum > maxSum)
           {
               count++;
               currentSum = num;
               if(count > k)
                   return false;
           }

       }
       return true;
    }
}