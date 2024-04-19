class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low=0,high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]==target)
                return mid;
            
            if(nums[low]<=nums[mid])
            {
                if(nums[low]<=target&& target<nums[mid])// target is in this sorted half. 
                    high=mid-1;
                else
                    low=mid+1;
            }
            else{
                if(nums[mid]<target && target<=nums[high])  //target is in this sorted right half
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;
        
    }
}