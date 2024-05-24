class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(Math.abs(i-j)>=indexDifference && Math.abs(nums[i]-nums[j])>=valueDifference)
                    return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
}