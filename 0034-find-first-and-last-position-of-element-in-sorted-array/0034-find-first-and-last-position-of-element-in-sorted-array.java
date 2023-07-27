class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f=first(nums,0,nums.length-1,target);
         int s=last(nums,0,nums.length-1,target);
        
        int ans[]={f,s};
        
        return ans;
    }
    int first(int arr[],int low,int high,int x)
    {
       if (high >= low) 
       {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
                return mid;
            else if (x > arr[mid])
                return first(arr, (mid + 1), high, x);
            else
                return first(arr, low, (mid - 1), x);
        }
        return -1;
    }
     int last(int arr[],int low,int high,int x)
    {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if ((mid == arr.length - 1 || x < arr[mid + 1])&& arr[mid] == x)
                return mid;
            else if (x < arr[mid])
                return last(arr, low, (mid - 1), x);
            else
                return last(arr, (mid + 1), high, x);
        }
        return -1;
    }
}