// class Solution {
//   public int minimumCost(int[] nums) {
//     final int n = nums.length;
//     int[] left = Arrays.copyOfRange(nums, 1, n);
//     Arrays.sort(left);

//     return left[0] + left[1] + nums[0];
//   }
// }

class Solution {
    public int minimumCost(int[] nums) 
    {
        int first = nums[0];
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for(int i=1; i<nums.length; i++)
        {
            if(min1 > nums[i])
            {
                min2 = min1;
                min1 = nums[i];
            }
            else if(min2 > nums[i]){
                min2 = nums[i];
            }
        }
        return first + min1 + min2;
    }
}