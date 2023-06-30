class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low=0,high=n-1;
        
        if(n==0)
            return -1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]==target)
                return mid;
            
            else if(nums[mid]<target)
                low++;
            else
                high--;
        }
        return -1;
    }
}