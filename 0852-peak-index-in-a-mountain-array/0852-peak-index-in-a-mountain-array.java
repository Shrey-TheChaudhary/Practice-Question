class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        if(n<3)
            return -1;
        
        int low=0,high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            
            if (arr[mid] < arr[mid + 1])
               low = mid+1;
            else 
                high = mid-1;
        }
        return low;
    }
}