class Solution {
    public int singleNonDuplicate(int[] nums) {
       int n =nums.length;
        int ans = 0;
      
        for (int i = 0; i < n; i++) 
            ans = ans^nums[i];
        
        return ans; 
    }
}