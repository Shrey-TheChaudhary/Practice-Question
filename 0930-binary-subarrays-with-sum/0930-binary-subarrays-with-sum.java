class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int total = 0;
        int sum = 0;
        int presum[] = new int[nums.length + 1];
        presum[0] = 1;
        
        for (int num : nums) {
            sum += num;
            if (sum >= goal) {
                total += presum[sum - goal];
            }
            presum[sum]++;
        }
        
        return total;
    }
}
// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int c=0;
//         for(int i=0;i<nums.length;i++){
//             int sum=0;
//             for(int j=i;j<nums.length;j++){
//                 sum+=nums[j];
//                 if(sum==goal)
//                     c++;
//             }
//         }
//         return c;
//     }
// }
