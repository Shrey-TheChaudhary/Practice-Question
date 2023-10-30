class Solution { 
   // public int smallestDivisor(int[] nums, int threshold) {
        //O(n)
        
//          int n = nums.length; //size of array.
//         //Find the maximum element:
//         int maxi = Integer.MIN_VALUE;
//         for (int i = 0; i < n; i++) {
//             maxi = Math.max(maxi, nums[i]);
//         }

//         //Find the smallest divisor:
//         for (int d = 1; d <= maxi; d++) {
//             //Find the summation result:
//             int sum = 0;
//             for (int i = 0; i < n; i++) {
//                 sum += Math.ceil((double)(nums[i]) / (double)(d));
//             }
//             if (sum <= threshold)
//                 return d;
//         }
//         return -1; 
    //}
    
    
    //Striver
    public int smallestDivisor(int[] nums, int threshold) 
    {
        //O(logn)
        int n = nums.length; //size of array.
        if(n > threshold) 
            return -1;
        //Find the maximum element:
        
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) 
            maxi = Math.max(maxi, nums[i]);
        int low = 1, high = maxi;

        //Apply binary search:
        while (low <= high) 
        {
            int mid = (low + high) / 2;
            if (sumByD(nums, mid) <= threshold) 
                high = mid - 1;
             else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static int sumByD(int[] nums, int div) {
        int n = nums.length; //size of array
        //Find the summation of division values:
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double)(nums[i]) / (double)(div));
        }
        return sum;
    }
        
}