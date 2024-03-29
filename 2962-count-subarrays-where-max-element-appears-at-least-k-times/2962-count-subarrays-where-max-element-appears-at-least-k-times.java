class Solution {
    public long countSubarrays(int[] nums, int k) {
        int left = 0;
        int maxvalue = Integer.MIN_VALUE;
        int count = 0;
        long result = 0;

        for(int num : nums){
            maxvalue = Math.max(maxvalue,num);
        }

        for(int i : nums)
        {
            if( i == maxvalue) 
                count++;

            while(count >= k)
            {
                if(nums[left++] == maxvalue) 
                    --count;
            }
            result += left;
        }
        return result;
    }
}