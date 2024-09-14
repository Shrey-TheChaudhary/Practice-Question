class Solution {
    public int longestSubarray(int[] nums) {
        int length = 0;
        int max = 0;

        // 1st loop to get largest value of nums array
        for(int i=0; i<nums.length; i++){
            max = Math.max(max,nums[i]);
        }

        // 2nd loop to get max count of largest value
        int count=0; // current count of max value
        for(int i=0; i<nums.length; i++){
            if(nums[i]==max){
                count++;
                length = Math.max(length,count);
            }else{
                count = 0;
            }
        }
        return length;
    }
}
