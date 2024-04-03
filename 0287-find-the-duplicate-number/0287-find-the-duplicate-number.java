class Solution {
    public int findDuplicate(int[] nums) {
        //-----------SOLUTION 1--------------
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
        
        
    //-----------SOLUTION 2--------------
    // Set<Integer> set = new HashSet<>();
    //     for(int num:nums){
    //         if(!set.add(num)){
    //             return num;
    //         }
    //     }
    // return nums.length;
    }
}