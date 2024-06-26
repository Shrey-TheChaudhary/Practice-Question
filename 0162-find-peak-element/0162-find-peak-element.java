//        o(n)
// class Solution {
//     public int findPeakElement(int[] nums) {
//         if(nums.length==1)
//             return 0;
        
       // if ((i == 0||arr[i-1]<arr.get[i])&&(i == n-1||arr[i] > arr[i+1])) 
       // {
       //          return i;

//         }
//         return 0;
//     }
// }

class Solution {
    public int findPeakElement(int[] nums) {
         int n = nums.length; // Length of array

        // Edge cases:
        if (n == 1) 
            return 0;
        if (nums[0] > nums[1]) 
            return 0;
        if (nums[n - 1] > nums[n - 2]) 
            return n - 1;

        int low = 1, high = n - 2;
        while (low <= high) 
        {
            int mid = (low + high) / 2;
            // If arr[mid] is the peak:
            if (nums[mid - 1]<nums[mid] && nums[mid]>nums[mid + 1])
                return mid;
            // If we are in the left:
            if (nums[mid] > nums[mid - 1]) 
                low = mid + 1;
            // If we are in the right or,arr[mid] is a common point:
            else 
                high = mid - 1;
        }
        // Dummy return statement
        return -1;
    }
}