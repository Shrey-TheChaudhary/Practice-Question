class Solution {
    public int findLengthOfLCIS(int[] nums) {
    
        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] > nums[i - 1]) 
                currentLength++;
             else 
                currentLength = 1;

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}