class Solution {
    public int minimumSum(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length-2;i++){
            for(int j = i + 1; j < nums.length-1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] < nums[j] && nums[k] < nums[j]){
                        if(count == 0){
                            count = nums[i] + nums[j] + nums[k];
                        }
                        count = Math.min(count,nums[i] + nums[j] + nums[k]);}
                    
                }

            }
        }
        if(count == 0){
            return -1;
        }
        return count;
    }
}